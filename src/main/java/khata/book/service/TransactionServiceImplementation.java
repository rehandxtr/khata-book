package khata.book.service;

import khata.book.model.Transaction;
import khata.book.model.TransactionRequestModel;
import khata.book.repository.TransactionRepository;
import khata.book.service.implementation.TransactionService;
import khata.book.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    Utils utils = new Utils();

    @Override
    public List<Transaction> getTransactions(UUID userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public void storeTransaction(UUID userId, TransactionRequestModel t) {
        Transaction transaction = new Transaction();
        transaction.setDate(t.getDate());
        transaction.setDescription(t.getDescription());
        transaction.setUserId(userId);
        transaction.setFlow(t.isFlow());
        transaction.setUuid(utils.generateRandomUUID());
        transaction.setValue(t.getValue());
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(UUID txnId, TransactionRequestModel t) {
       Transaction transaction = transactionRepository.findByUuid(txnId);
       if (transaction == null) {
           return null;
       } else {
           transaction.setValue(t.getValue());
           transaction.setDate(t.getDate());
           transaction.setDescription(t.getDescription());
           transaction.setFlow(t.isFlow());
           transaction.setValue(t.getValue());
           transactionRepository.save(transaction);
           return transaction;
       }
    }

    @Override
    public void deleteTransaction(UUID uuid) {
        transactionRepository.deleteTransactionByUuid(uuid);
    }

}

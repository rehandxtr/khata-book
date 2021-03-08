package khata.book.service.implementation;

import khata.book.model.Transaction;
import khata.book.model.TransactionRequestModel;

import java.util.List;
import java.util.UUID;


public interface TransactionService {
    List<Transaction> getTransactions(UUID uuid);
    void storeTransaction(UUID userId, TransactionRequestModel t);
    Transaction updateTransaction(UUID txnId, TransactionRequestModel t);
    void deleteTransaction(UUID uuid);
}

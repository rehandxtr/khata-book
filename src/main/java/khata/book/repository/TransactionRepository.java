package khata.book.repository;

import khata.book.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends MongoRepository<Transaction,Integer> {
    Transaction findByUuid(UUID uuid);
    List<Transaction> findByUserId(UUID uuid);
    boolean deleteTransactionByUuid(UUID uuid);
}

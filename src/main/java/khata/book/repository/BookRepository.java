package khata.book.repository;

import khata.book.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends MongoRepository<Books, Integer> {
    List<Books> findByUserId(UUID uuid);
}

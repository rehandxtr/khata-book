package khata.book.service.implementation;

import khata.book.model.Books;

import java.util.List;
import java.util.UUID;

public interface BooksService {
    List<Books> getBooks(UUID uuid);
    void addBook();
    Books updateBook();
    void deleteBook();
}

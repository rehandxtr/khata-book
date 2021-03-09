package khata.book.service;

import khata.book.model.Books;
import khata.book.repository.BookRepository;
import khata.book.service.implementation.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BooksServiceImplementation implements BooksService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Books> getBooks(UUID uuid) {
        bookRepository.findByUserId(uuid);
     return null;
    }

    @Override
    public void addBook() {

    }

    @Override
    public Books updateBook() {

     return null;
    }

    @Override
    public void deleteBook() {

    }
}

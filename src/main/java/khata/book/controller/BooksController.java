package khata.book.controller;

import khata.book.model.BookRequestModel;
import khata.book.service.BooksServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book/{userId}")
public class BooksController {

    @Autowired
    BooksServiceImplementation booksServiceImplementation;

    @GetMapping
    ResponseEntity<?> getBooks(@PathVariable UUID userId){
        try {
            return new ResponseEntity<>(booksServiceImplementation.getBooks(userId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error in getting books",HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping
    ResponseEntity<?> storeBook(@RequestBody BookRequestModel bookRequestModel){
       return null;
    }

    @PutMapping("/{id}/{name}")
    void updateBook(@PathVariable String id,@PathVariable String name){
        System.out.println("updated book name is "+ name);
    }

    @DeleteMapping("/{id}")
    void DeleteBook(@PathVariable String id){
        System.out.println("Deleted Book is" +id);
    }

}

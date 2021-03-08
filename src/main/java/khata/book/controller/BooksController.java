package khata.book.controller;

import khata.book.model.BookRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BooksController {
    @GetMapping
    void getBooks(){
        System.out.println("getting all the books related to a user");
    }
    @PostMapping
    void storeBook(@RequestBody BookRequestModel bookRequestModel){
        System.out.println("saved book is "+bookRequestModel);
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

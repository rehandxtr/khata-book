package khata.book;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BooksController {
    @GetMapping
    void getBooks(){
        System.out.println("getting all the books related to a user");
    }
    @PostMapping
    void storeBook(){

    }
    @PutMapping("/{id}/{name}")
    void updateBook(@PathVariable String id,@PathVariable String name){

    }
    @DeleteMapping
    void DeleteBook(){

    }

}

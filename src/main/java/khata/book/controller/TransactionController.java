package khata.book.controller;

import khata.book.model.Transaction;
import khata.book.model.TransactionRequestModel;
import khata.book.repository.TransactionRepository;
import khata.book.service.TransactionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/trnx/{uuid}")
public class TransactionController {
    @Autowired
    TransactionServiceImplementation transactionService;
    @Autowired
    TransactionRepository transactionRepository;
    @GetMapping
    ResponseEntity<?> getTransactions(@PathVariable UUID uuid){
     try{
         return new ResponseEntity<>(transactionService.getTransactions(uuid),HttpStatus.OK);
     } catch (Exception e){
         System.out.println(e.getMessage());
         return new ResponseEntity<>("Error in Fetching data",HttpStatus.EXPECTATION_FAILED);
     }
    }

    @PostMapping
    ResponseEntity<?> addTransaction(@PathVariable UUID uuid,@RequestBody TransactionRequestModel transactionRequestModel){
       try {
           transactionService.storeTransaction(uuid,transactionRequestModel);
           return new ResponseEntity<>("transaction created",HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>("Error in saving data",HttpStatus.EXPECTATION_FAILED);
       }

    }

    @PutMapping
    ResponseEntity<?> updateTransaction(@PathVariable("uuid") UUID txnId, @RequestBody TransactionRequestModel transactionRequestModel){
      try {
          Transaction transaction = transactionService.updateTransaction(txnId,transactionRequestModel);
          if (transaction == null){
              return new ResponseEntity<>("No transaction found",HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>("updated the transaction",HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>("Error in updating data",HttpStatus.EXPECTATION_FAILED);
      }
    }

    @DeleteMapping
    ResponseEntity<?> deleteTransaction(@PathVariable UUID uuid){
        try {
            transactionService.deleteTransaction(uuid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error in Fetching data",HttpStatus.EXPECTATION_FAILED);
        }
    }
}

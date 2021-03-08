package khata.book.model;

import lombok.Data;

@Data
public class TransactionRequestModel {

    String date;
    String description;
    String value;
    boolean flow;

}

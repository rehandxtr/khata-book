package khata.book.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "transaction")
public class Transaction {
    @Id
    UUID uuid;
    UUID userId;
    String date;
    String value;
    boolean flow;
    String description;
}

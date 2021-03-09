package khata.book.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "costumer")
public class Costumers {
    @Id
    UUID uuid;
    UUID userId;
    String name;
    String value;
    String flow;
}

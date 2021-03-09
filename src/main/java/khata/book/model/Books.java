package khata.book.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "books")
public class Books {
    @Id
    UUID uuid;
    UUID userId;
    Double willGet;
    Double willGive;
    List<Costumers> costumers;
}

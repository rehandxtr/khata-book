package khata.book.model;

import lombok.Data;

import java.util.UUID;

@Data
public class BookRequestModel {
    UUID id;
    UUID userId;
    String name;
}

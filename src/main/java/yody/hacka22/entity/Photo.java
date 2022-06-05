package yody.hacka22.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photo")
@Data
public class Photo {
    @Id
    private String id;
    private byte[] bytes;
}

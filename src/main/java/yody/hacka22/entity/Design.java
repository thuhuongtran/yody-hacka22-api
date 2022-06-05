package yody.hacka22.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("design")
@Accessors(chain = true)
public class Design {
    @Id
    private String id;
    private String title;
    private String description;
    private String imageBase64;
    private Double price;
    private List<String> tags;
}

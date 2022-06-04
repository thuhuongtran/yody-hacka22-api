package yody.hacka22.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("card")
@Accessors(chain = true)
public class Card {
    @Id
    private String id;
    private User user;
    private String accountNumber;
    private Date expireDate;
    private String cvv;
}

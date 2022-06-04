package yody.hacka22.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import yody.hacka22.enums.GlobalEnum;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "user")
public class User {
    @Id
    String id;
    String name;
    String phoneNumber;
    String detailAddress;
    GlobalEnum.Role role;
    String loginNamed;
    String password; // base64
}

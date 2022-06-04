package yody.hacka22.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import yody.hacka22.enums.GlobalEnum;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("shirt")
@Accessors(chain = true)
public class Shirt {
    @Id
    private String id;
    private String title;
    private GlobalEnum.ShirtType type;
    private GlobalEnum.ShirtColor color;
    private String imageLink;
    private String designDecorationImageLink;
    private GlobalEnum.ShirtSize size;
}

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
@Document("template-shirt")
@Accessors(chain = true)
public class TemplateShirt {
    @Id
    private String id;
    private GlobalEnum.ShirtType type;
    private GlobalEnum.ShirtColor color;
    private String templateImageLink;
    private GlobalEnum.ShirtSize size;
    private Integer storageCount;
    private Double corePrice;
}

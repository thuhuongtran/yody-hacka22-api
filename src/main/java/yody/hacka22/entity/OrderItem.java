package yody.hacka22.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("order_item")
@Accessors(chain = true)
public class OrderItem {
    @Id
    private String id;
    private String orderId;
    private DesignShirt designShirt;
    private Double price;
    private Integer count;
}

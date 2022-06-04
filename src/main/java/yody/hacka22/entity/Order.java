package yody.hacka22.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import yody.hacka22.enums.GlobalEnum;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "order")
public class Order {
    @Id
    String id;
    LocalDate orderDate;
    String customerId;
    GlobalEnum.PaymentMethod paymentMethod;
    Double shippingFee;
    Double totalCost ;
    LocalDate estimatedShippingDate;
    List<OrderItem> orderItemList;
}

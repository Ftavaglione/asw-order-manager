package asw.ordermanager.ordervalidation.api.event;

import asw.ordermanager.common.api.event.DomainEvent;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class OrderCreatedEvent implements DomainEvent{

    private Long id;
    private String customer;
    private String address;
    private List<OrderItemElement> orderItems;
    private double total;

}
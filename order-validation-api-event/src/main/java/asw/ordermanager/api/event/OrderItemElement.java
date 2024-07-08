package asw.ordermanager.ordervalidation.api.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemElement {

    private String product;
    private int quantity;

}
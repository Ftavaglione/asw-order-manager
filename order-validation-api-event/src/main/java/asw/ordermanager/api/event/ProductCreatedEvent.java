package asw.ordermanager.ordervalidation.api.event;

import asw.ordermanager.common.api.event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class ProductCreatedEvent implements DomainEvent{

	private String name;
	private String category;
	private int stockLevel;
	private double price;
}
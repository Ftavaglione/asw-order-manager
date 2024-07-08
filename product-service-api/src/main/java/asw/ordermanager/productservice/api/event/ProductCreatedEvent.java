package asw.ordermanager.productservice.api.event;

import asw.ordermanager.common.api.event.DomainEvent;
import lombok.*;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class ProductCreatedEvent implements DomainEvent{

	private String name;
	private String category;
	private int stockLevel;
	private double price;
}
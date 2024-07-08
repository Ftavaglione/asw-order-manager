package asw.ordermanager.ordervalidationservice.domain;

import jakarta.persistence.*; 

import java.util.*; 

import lombok.*; 

/* Ordine. */ 
@Entity 
@Table(name="VALIDATION_ORDERS")
@Data 
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Comparable<Order> {

	@Id
	@EqualsAndHashCode.Include
	private Long id; 	
	private String customer; 
	@ElementCollection(fetch = FetchType.EAGER)										
	private List<OrderItem> orderItems;
	//private double total; 

	@Override
	public int compareTo(Order other) {
		return this.id.compareTo(other.id); 
	}
	
}

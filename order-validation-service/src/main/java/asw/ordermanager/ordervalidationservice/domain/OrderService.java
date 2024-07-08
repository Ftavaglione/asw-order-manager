package asw.ordermanager.ordervalidationservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;


 	public Order createOrder(Long id, String customer, List<OrderItem> orderItems) {

		Order order = new Order(id, customer, orderItems);
		order = orderRepository.save(order);
		return order;
	}

 	public Order getOrder(Long id) {
		Order order = orderRepository.findById(id).orElse(null);
		return order;
	}
	
}
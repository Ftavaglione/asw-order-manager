package asw.ordermanager.orderservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.api.event.*;


import java.util.logging.Logger;															  

import java.util.*; 

@Service
public class OrderService {

	private final Logger logger = Logger.getLogger(this.getClass().toString());																		
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderEventPublisher orderEventPublisher;

 	public Order createOrder(String customer, String address, List<OrderItem> orderItems, double total) {
		Order order = new Order(customer, address, orderItems, total); 
		order = orderRepository.save(order);
		List<OrderItemElement> orderItemeElementList = new ArrayList<>();
		for(OrderItem orderItem : order.getOrderItems()){
			OrderItemElement orderItemElement = new OrderItemElement(orderItem.getProduct(),orderItem.getQuantity());
			orderItemeElementList.add(orderItemElement);
		}

		DomainEvent event = new OrderCreatedEvent(order.getId(), order.getCustomer(),order.getAddress(),orderItemeElementList,order.getTotal());
		orderEventPublisher.publish(event);
        logger.info("ordine creato correttamente!");																																  
		return order;
	}

 	public Order getOrder(Long id) {
		Order order = orderRepository.findById(id).orElse(null);
		return order;
	}

	public Collection<Order> getOrders() {
		Collection<Order> orders = orderRepository.findAll();
		return orders;
	}

	public Collection<Order> getOrdersByCustomer(String customer) {
		Collection<Order> orders = orderRepository.findByCustomer(customer);
		return orders;
	}

	public Collection<Order> getOrdersByProduct(String product) {
		Collection<Order> orders = orderRepository.findByOrderItems_Product(product);
		return orders;
	}
	
}

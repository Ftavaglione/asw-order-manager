package asw.ordermanager.ordervalidationservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

import java.util.Collection;
import java.util.List;

@Service
public class OrderService {

	private final Logger logger = Logger.getLogger(this.getClass().toString());																	
	@Autowired
	private OrderRepository orderRepository;


 	public Order createOrder(Long id, String customer, List<OrderItem> orderItems) {
		
		Order order = new Order(id, customer, orderItems);
		
		try{
			order = orderRepository.save(order);
			logger.info("Ordine salvato correttamente!");			
		} catch (Exception e){
			logger.info("errore nel salvataggio!" + e.getMessage());
			e.printStackTrace();
		}			
		return order;
	}

 	public Order getOrder(Long id) {
		Order order = orderRepository.findById(id).orElse(null);
		return order;
	}
	
}
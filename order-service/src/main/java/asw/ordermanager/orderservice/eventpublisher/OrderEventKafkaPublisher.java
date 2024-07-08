package asw.ordermanager.orderservice.eventpublisher;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.orderservice.api.event.*; 
import asw.ordermanager.orderservice.domain.OrderEventPublisher;

import org.springframework.kafka.core.KafkaTemplate;
																																 
import java.util.logging.Logger;
													

@Component
public class OrderEventKafkaPublisher implements OrderEventPublisher{

	@Autowired
	private KafkaTemplate<String, DomainEvent> template;

	private String channel = OrderServiceEventChannel.orderCreated;																												
			 
	public void publish(DomainEvent event) {
																						
		template.send(channel, event);
	}

}

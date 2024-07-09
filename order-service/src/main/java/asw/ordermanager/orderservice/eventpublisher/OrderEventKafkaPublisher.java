package asw.ordermanager.orderservice.eventpublisher;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.api.event.*; 
import asw.ordermanager.orderservice.domain.OrderEventPublisher;

import org.springframework.kafka.core.KafkaTemplate;
																																 
import java.util.logging.Logger;
													

@Component
public class OrderEventKafkaPublisher implements OrderEventPublisher{

	private final Logger logger = Logger.getLogger(this.getClass().toString());																		   
	@Autowired
	private KafkaTemplate<String, DomainEvent> template;

	private String channel = OrderServiceEventChannel.orderCreated;																												
			 
	public void publish(DomainEvent event) {
		logger.info("EVENT PUBLISHER: " + event.toString() + " on CHANNEL: " + channel);																				
		template.send(channel, event);
	}

}

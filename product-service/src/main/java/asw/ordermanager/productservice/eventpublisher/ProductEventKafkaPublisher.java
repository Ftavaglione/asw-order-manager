package asw.ordermanager.productservice.eventpublisher;

import asw.ordermanager.api.event.ProductCreatedEvent;
import asw.ordermanager.api.event.ProductServiceEventChannel;
import asw.ordermanager.api.event.UpdateStockLevelEvent;
import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.productservice.domain.ProductEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ProductEventKafkaPublisher implements ProductEventPublisher {

	private final Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = null;

    @Override
    public void publish(DomainEvent event) {
        if(event instanceof ProductCreatedEvent)
            channel = ProductServiceEventChannel.productCreated;
        else if(event instanceof UpdateStockLevelEvent)
            channel = ProductServiceEventChannel.updateStockLevel;
		logger.info("EVENT PUBLISHER: " + event.toString() + " on CHANNEL: " + channel);
        template.send(channel, event);
    }

}

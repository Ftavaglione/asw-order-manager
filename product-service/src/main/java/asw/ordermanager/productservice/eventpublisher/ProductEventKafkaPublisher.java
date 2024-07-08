package asw.ordermanager.productservice.eventpublisher;

import asw.ordermanager.productservice.api.event.ProductCreatedEvent;
import asw.ordermanager.productservice.api.event.ProductServiceEventChannel;
import asw.ordermanager.productservice.api.event.UpdateStockLevelEvent;
import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.productservice.domain.ProductEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ProductEventKafkaPublisher implements ProductEventPublisher {

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = null;

    @Override
    public void publish(DomainEvent event) {
        if(event instanceof ProductCreatedEvent)
            channel = ProductServiceEventChannel.productCreated;
        else if(event instanceof UpdateStockLevelEvent)
            channel = ProductServiceEventChannel.updateStockLevel;

        template.send(channel, event);
    }

}

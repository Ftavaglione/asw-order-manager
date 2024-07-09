package asw.ordermanager.ordervalidationservice.ordervalidationeventlistener;

import asw.ordermanager.api.event.OrderValidationEventChannel;
import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.ordervalidationservice.domain.OrderValidationEventConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

								

@Component
public class OrderValidationEventKafkaListener {
	private final Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private OrderValidationEventConsumer orderValidationEventConsumer;

        @KafkaListener(topics = {OrderValidationEventChannel.orderCreated, OrderValidationEventChannel.productCreated, OrderValidationEventChannel.updateStockLevel})
    public void listen(ConsumerRecord<String, DomainEvent> record)throws Exception {
		logger.info("EVENT LISTENER:" +  record.toString());
		
        DomainEvent event = record.value();
                orderValidationEventConsumer.onEvent(event);
    }
}

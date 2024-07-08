package asw.ordermanager.ordervalidationservice.ordervalidationeventlistener;

import asw.ordermanager.ordervalidation.api.event.OrderValidationEventChannel;
import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.ordervalidationservice.domain.OrderValidationEventConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

@Component
public class OrderValidationEventKafkaListener {


    @Autowired
    private OrderValidationEventConsumer orderValidationEventConsumer;

        @KafkaListener(topics = {OrderValidationEventChannel.orderCreated, OrderValidationEventChannel.productCreated, OrderValidationEventChannel.updateStockLevel})
    public void listen(ConsumerRecord<String, DomainEvent> record)throws Exception {
       
        DomainEvent event = record.value();
                orderValidationEventConsumer.onEvent(event);
    }
}

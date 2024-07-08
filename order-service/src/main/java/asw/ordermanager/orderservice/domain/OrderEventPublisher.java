package asw.ordermanager.orderservice.domain;

import asw.ordermanager.common.api.event.DomainEvent;

public interface OrderEventPublisher{

    public void publish(DomainEvent event);

}
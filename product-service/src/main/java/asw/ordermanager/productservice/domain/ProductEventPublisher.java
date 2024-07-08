package asw.ordermanager.productservice.domain;

import asw.ordermanager.common.api.event.DomainEvent;

public interface ProductEventPublisher {

    public void publish(DomainEvent event);

}
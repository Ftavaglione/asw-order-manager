package asw.ordermanager.ordervalidationservice.domain;

import asw.ordermanager.ordervalidation.api.event.OrderCreatedEvent;
import asw.ordermanager.ordervalidation.api.event.OrderItemElement;
import asw.ordermanager.ordervalidation.api.event.ProductCreatedEvent;
import asw.ordermanager.ordervalidation.api.event.UpdateStockLevelEvent;
import asw.ordermanager.common.api.event.DomainEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderValidationEventConsumer {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    public void onEvent(DomainEvent event) {
        if (event instanceof OrderCreatedEvent evt) {
            onOrderCreated(evt);
        } else if (event instanceof ProductCreatedEvent evt) {
            onProductCreated(evt);
        } else if (event instanceof UpdateStockLevelEvent evt) {
            onUpdateStockLevel(evt);
        }

    }

    private void onUpdateStockLevel(UpdateStockLevelEvent evt) {
        productService.updateProductStockLevel(evt.getName(), evt.getStockLevelVariation());
    }

    private void onProductCreated(ProductCreatedEvent evt) {
        productService.createProduct(evt.getName(), evt.getStockLevel());
    }

    private void onOrderCreated(OrderCreatedEvent evt) {
        List<OrderItem> orderItemList= new ArrayList<>();
        for(OrderItemElement orderItemElement: evt.getOrderItems()){
            OrderItem orderItem= new OrderItem(orderItemElement.getProduct(),orderItemElement.getQuantity());
            orderItemList.add(orderItem);
        }
        orderService.createOrder(evt.getId(), evt.getCustomer(),orderItemList);
    }

}

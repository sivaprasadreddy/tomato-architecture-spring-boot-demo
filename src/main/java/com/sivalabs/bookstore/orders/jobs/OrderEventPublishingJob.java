package com.sivalabs.bookstore.orders.jobs;

import com.sivalabs.bookstore.orders.OrderDTO;
import com.sivalabs.bookstore.orders.OrderItem;
import com.sivalabs.bookstore.orders.OrderStatus;
import com.sivalabs.bookstore.orders.OrdersAPI;
import com.sivalabs.bookstore.orders.events.OrderCreatedEvent;
import com.sivalabs.bookstore.orders.events.OrderEventPublisher;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
class OrderEventPublishingJob {
    private static final Logger log = LoggerFactory.getLogger(OrderEventPublishingJob.class);
    private final OrdersAPI ordersAPI;
    private final OrderEventPublisher orderEventPublisher;

    OrderEventPublishingJob(OrdersAPI ordersAPI, OrderEventPublisher orderEventPublisher) {
        this.ordersAPI = ordersAPI;
        this.orderEventPublisher = orderEventPublisher;
    }

    @Scheduled(cron = "${app.new-orders-job-cron}")
    void processNewOrders() {
        log.info("Processing new orders job started at {}", Instant.now());
        List<OrderDTO> newOrders = ordersAPI.findOrdersByStatus(OrderStatus.NEW);
        for (OrderDTO order : newOrders) {
            var orderCreatedEvent = this.buildOrderCreatedEvent(order);
            orderEventPublisher.send(orderCreatedEvent);
            log.info("Published OrderCreatedEvent for orderNumber:{}", order.orderNumber());
        }
        log.info("Processing new orders job completed at {}", Instant.now());
    }

    private OrderCreatedEvent buildOrderCreatedEvent(OrderDTO order) {
        var orderItems = order.items().stream()
                .map(item -> new OrderItem(item.code(), item.name(), item.price(), item.quantity()))
                .collect(Collectors.toSet());
        return new OrderCreatedEvent(order.orderNumber(), orderItems, order.customer(), order.deliveryAddress());
    }
}

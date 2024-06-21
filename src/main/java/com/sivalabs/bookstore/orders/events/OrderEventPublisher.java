package com.sivalabs.bookstore.orders.events;

import com.sivalabs.bookstore.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {
    private static final Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ApplicationProperties properties;

    public OrderEventPublisher(KafkaTemplate<String, Object> kafkaTemplate, ApplicationProperties properties) {
        this.kafkaTemplate = kafkaTemplate;
        this.properties = properties;
    }

    public void send(OrderCreatedEvent event) {
        this.send(properties.newOrdersTopic(), event);
    }

    private void send(String topic, Object payload) {
        kafkaTemplate.send(topic, payload).thenRun(() -> log.info("Sent event {} to topic {}", payload, topic));
    }
}

package com.sivalabs.bookstore.catalog.events;

import com.sivalabs.bookstore.catalog.CatalogAPI;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class ProductPriceChangedEventHandler {
    private final CatalogAPI catalogAPI;

    ProductPriceChangedEventHandler(CatalogAPI catalogAPI) {
        this.catalogAPI = catalogAPI;
    }

    @KafkaListener(topics = "${app.product-price-updates-topic}", groupId = "catalog")
    public void handle(ProductPriceChangedEvent event) {
        catalogAPI.updatePrice(event.code(), event.price());
    }
}

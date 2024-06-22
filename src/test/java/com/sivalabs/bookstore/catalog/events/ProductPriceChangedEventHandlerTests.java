package com.sivalabs.bookstore.catalog.events;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.sivalabs.bookstore.AbstractIT;
import com.sivalabs.bookstore.ApplicationProperties;
import com.sivalabs.bookstore.catalog.CatalogAPI;
import com.sivalabs.bookstore.catalog.Product;
import java.math.BigDecimal;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.jdbc.Sql;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@Sql("/test-products-data.sql")
class ProductPriceChangedEventHandlerTests extends AbstractIT {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    ApplicationProperties properties;

    @Autowired
    CatalogAPI catalogAPI;

    @Test
    void shouldConsumeAndProcessEventSuccessfully() {
        String code = "P100";
        Product product = catalogAPI.findProductByCode(code).orElseThrow();
        assertThat(product.price().compareTo(new BigDecimal("34.0"))).isEqualTo(0);
        var event = new ProductPriceChangedEvent(code, new BigDecimal("100.00"));
        kafkaTemplate.send(properties.productPriceUpdatesTopic(), event);

        await().pollInterval(Duration.ofSeconds(3)).atMost(10, SECONDS).untilAsserted(() -> {
            var updatedProduct = catalogAPI.findProductByCode(code).orElseThrow();
            assertThat(updatedProduct.price().compareTo(new BigDecimal("100.0")))
                    .isEqualTo(0);
        });
    }
}

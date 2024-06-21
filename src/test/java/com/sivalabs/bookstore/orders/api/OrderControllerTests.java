package com.sivalabs.bookstore.orders.api;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.sivalabs.bookstore.AbstractIT;
import com.sivalabs.bookstore.catalog.CatalogAPI;
import com.sivalabs.bookstore.catalog.Product;
import com.sivalabs.bookstore.orders.CreateOrderResponse;
import com.sivalabs.bookstore.orders.OrderDTO;
import com.sivalabs.bookstore.orders.OrdersAPI;
import io.restassured.http.ContentType;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.jdbc.Sql;

@ApplicationModuleTest(webEnvironment = RANDOM_PORT)
@Sql({"/test-orders-data.sql"})
class OrderControllerTests extends AbstractIT {
    @MockBean
    private CatalogAPI catalogAPI;

    @Autowired
    private OrdersAPI ordersAPI;

    String productCode = "P100";
    String orderNumber = "order-123";

    @BeforeEach
    void setUpMock() {

        BDDMockito.given(catalogAPI.findProductByCode(productCode))
                .willReturn(Optional.of(new Product(1L, productCode, "", "", "", new BigDecimal("34.0"))));
    }

    @Test
    void shouldCreateOrderSuccessfully() {
        CreateOrderResponse createOrderResponse = given().contentType(ContentType.JSON)
                .body(
                        """

                                        {
                                        "customer" : {
                                            "name": "Siva",
                                            "email": "siva@gmail.com",
                                            "phone": "999999999"
                                        },
                                        "deliveryAddress" : {
                                            "addressLine1": "KPHB",
                                            "addressLine2": "",
                                            "city": "Hyderabad",
                                            "state": "TS",
                                            "zipCode": "500072",
                                            "country": "India"
                                        },
                                        "items": [
                                            {
                                                "code": "%s",
                                                "name": "The Hunger Games",
                                                "price": 34.0,
                                                "quantity": 1
                                            }
                                        ]
                                    }
                                    """
                                .formatted(productCode))
                .when()
                .post("/api/orders")
                .then()
                .statusCode(201)
                .body("orderNumber", notNullValue())
                .extract()
                .body()
                .as(CreateOrderResponse.class);

        Optional<OrderDTO> orderOptional = ordersAPI.findOrder(createOrderResponse.orderNumber());
        assertThat(orderOptional).isPresent();
        // Add more assertions - Exercise for the reader :-)
    }

    @Test
    // TODO; Make it a parameterized test and pass different invalid Order payloads
    void shouldReturnBadRequestWhenMandatoryDataIsMissing() {
        given().contentType(ContentType.JSON)
                .body(
                        """
                                    {
                                        "customer" : {
                                            "name": "Siva",
                                            "email": "siva@gmail.com",
                                            "phone": ""
                                        },
                                        "deliveryAddress" : {
                                            "addressLine1": "KPHB",
                                            "addressLine2": "",
                                            "city": "Hyderabad",
                                            "state": "TS",
                                            "zipCode": "500072",
                                            "country": "India"
                                        },
                                        "items": [
                                            {
                                                "code": "P100",
                                                "name": "The Hunger Games",
                                                "price": 34.00,
                                                "quantity": 1
                                            }
                                        ]
                                    }
                                    """)
                .when()
                .post("/api/orders")
                .then()
                .statusCode(400);
    }

    @Test
    void shouldGetOrderSuccessfully() {
        OrderDTO orderDTO = given().when()
                .get("/api/orders/{orderNumber}", orderNumber)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(OrderDTO.class);

        assertThat(orderDTO.orderNumber()).isEqualTo(orderNumber);
        assertThat(orderDTO.items()).hasSize(2);
        // Add more assertions - Exercise for the reader :-)
    }

    @Test
    void shouldReturnNotFoundWhenOrderNumberNotExist() {
        given().when()
                .get("/api/orders/{orderNumber}", "non-existing-order-number")
                .then()
                .statusCode(404);
    }
}

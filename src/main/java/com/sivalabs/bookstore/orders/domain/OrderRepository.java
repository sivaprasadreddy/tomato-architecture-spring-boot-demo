package com.sivalabs.bookstore.orders.domain;

import static com.sivalabs.bookstore.jooq.models.Tables.ORDERS;
import static com.sivalabs.bookstore.jooq.models.Tables.ORDER_ITEMS;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

import com.sivalabs.bookstore.orders.Address;
import com.sivalabs.bookstore.orders.CreateOrderRequest;
import com.sivalabs.bookstore.orders.CreateOrderResponse;
import com.sivalabs.bookstore.orders.Customer;
import com.sivalabs.bookstore.orders.OrderDTO;
import com.sivalabs.bookstore.orders.OrderItem;
import com.sivalabs.bookstore.orders.OrderStatus;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.jooq.DSLContext;
import org.jooq.Record14;
import org.jooq.SelectJoinStep;
import org.springframework.stereotype.Repository;

@Repository
class OrderRepository {
    private final DSLContext dsl;

    OrderRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        var orderNumber = UUID.randomUUID().toString();
        var orderId = dsl.insertInto(ORDERS)
                .set(ORDERS.ORDER_NUMBER, orderNumber)
                .set(ORDERS.CUSTOMER_NAME, request.customer().name())
                .set(ORDERS.CUSTOMER_EMAIL, request.customer().email())
                .set(ORDERS.CUSTOMER_PHONE, request.customer().phone())
                .set(ORDERS.DELIVERY_ADDRESS_LINE1, request.deliveryAddress().addressLine1())
                .set(ORDERS.DELIVERY_ADDRESS_LINE2, request.deliveryAddress().addressLine2())
                .set(ORDERS.DELIVERY_ADDRESS_CITY, request.deliveryAddress().city())
                .set(ORDERS.DELIVERY_ADDRESS_STATE, request.deliveryAddress().state())
                .set(ORDERS.DELIVERY_ADDRESS_ZIP_CODE, request.deliveryAddress().zipCode())
                .set(ORDERS.DELIVERY_ADDRESS_COUNTRY, request.deliveryAddress().country())
                .set(ORDERS.STATUS, OrderStatus.NEW.name())
                .set(ORDERS.CREATED_AT, LocalDateTime.now(ZoneId.systemDefault()))
                .returning(ORDERS.ID)
                .fetchOne(ORDERS.ID);

        request.items().forEach(item -> dsl.insertInto(ORDER_ITEMS)
                .set(ORDER_ITEMS.ORDER_ID, orderId)
                .set(ORDER_ITEMS.CODE, item.code())
                .set(ORDER_ITEMS.NAME, item.name())
                .set(ORDER_ITEMS.PRICE, item.price())
                .set(ORDER_ITEMS.QUANTITY, item.quantity())
                .execute());

        return new CreateOrderResponse(orderNumber);
    }

    public void updateOrderStatus(String orderNumber, OrderStatus status, String comments) {
        dsl.update(ORDERS)
                .set(ORDERS.STATUS, status.name())
                .set(ORDERS.COMMENTS, comments)
                .where(ORDERS.ORDER_NUMBER.eq(orderNumber))
                .execute();
    }

    public Optional<OrderDTO> findByOrderNumber(String orderNumber) {
        return selectOrderClause()
                .where(ORDERS.ORDER_NUMBER.eq(orderNumber))
                .fetchOptional()
                .map(this::mapToOrderDTO);
    }

    public List<OrderDTO> findByStatus(OrderStatus status) {
        return selectOrderClause()
                .where(ORDERS.STATUS.eq(status.name()))
                .fetch()
                .map(this::mapToOrderDTO);
    }

    private SelectJoinStep<
                    Record14<
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            LocalDateTime,
                            List<OrderItem>>>
            selectOrderClause() {
        return dsl.select(
                        ORDERS.ORDER_NUMBER,
                        ORDERS.CUSTOMER_NAME,
                        ORDERS.CUSTOMER_EMAIL,
                        ORDERS.CUSTOMER_PHONE,
                        ORDERS.DELIVERY_ADDRESS_LINE1,
                        ORDERS.DELIVERY_ADDRESS_LINE2,
                        ORDERS.DELIVERY_ADDRESS_CITY,
                        ORDERS.DELIVERY_ADDRESS_STATE,
                        ORDERS.DELIVERY_ADDRESS_ZIP_CODE,
                        ORDERS.DELIVERY_ADDRESS_COUNTRY,
                        ORDERS.STATUS,
                        ORDERS.COMMENTS,
                        ORDERS.CREATED_AT,
                        multiset(select(ORDER_ITEMS.CODE, ORDER_ITEMS.NAME, ORDER_ITEMS.PRICE, ORDER_ITEMS.QUANTITY)
                                        .from(ORDER_ITEMS)
                                        .where(ORDER_ITEMS.ORDER_ID.eq(ORDERS.ID)))
                                .as("items")
                                .convertFrom(rs -> rs.map(it -> new OrderItem(
                                        it.get(ORDER_ITEMS.CODE),
                                        it.get(ORDER_ITEMS.NAME),
                                        it.get(ORDER_ITEMS.PRICE),
                                        it.get(ORDER_ITEMS.QUANTITY)))))
                .from(ORDERS);
    }

    private OrderDTO mapToOrderDTO(
            Record14<
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            String,
                            LocalDateTime,
                            List<OrderItem>>
                    r) {
        return new OrderDTO(
                r.get(ORDERS.ORDER_NUMBER),
                r.value14(),
                new Customer(r.get(ORDERS.CUSTOMER_NAME), r.get(ORDERS.CUSTOMER_EMAIL), r.get(ORDERS.CUSTOMER_PHONE)),
                new Address(
                        r.get(ORDERS.DELIVERY_ADDRESS_LINE1),
                        r.get(ORDERS.DELIVERY_ADDRESS_LINE2),
                        r.get(ORDERS.DELIVERY_ADDRESS_CITY),
                        r.get(ORDERS.DELIVERY_ADDRESS_STATE),
                        r.get(ORDERS.DELIVERY_ADDRESS_ZIP_CODE),
                        r.get(ORDERS.DELIVERY_ADDRESS_COUNTRY)),
                OrderStatus.valueOf(r.get(ORDERS.STATUS)),
                r.get(ORDERS.COMMENTS),
                r.get(ORDERS.CREATED_AT));
    }
}

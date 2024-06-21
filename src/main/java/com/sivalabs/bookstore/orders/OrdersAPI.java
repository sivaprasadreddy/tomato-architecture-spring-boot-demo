package com.sivalabs.bookstore.orders;

import java.util.List;
import java.util.Optional;

public interface OrdersAPI {
    Optional<OrderDTO> findOrder(String orderNumber);

    List<OrderDTO> findOrdersByStatus(OrderStatus status);

    CreateOrderResponse createOrder(CreateOrderRequest request);
}

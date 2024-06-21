package com.sivalabs.bookstore.orders;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        String orderNumber,
        List<OrderItem> items,
        Customer customer,
        Address deliveryAddress,
        OrderStatus status,
        String comments,
        LocalDateTime createdAt) {}

package com.sivalabs.bookstore.orders.events;

import com.sivalabs.bookstore.orders.Address;
import com.sivalabs.bookstore.orders.Customer;
import com.sivalabs.bookstore.orders.OrderItem;
import java.util.Set;

public record OrderCreatedEvent(String orderNumber, Set<OrderItem> items, Customer customer, Address deliveryAddress) {}

package com.sivalabs.bookstore.orders.domain;

import com.sivalabs.bookstore.catalog.CatalogAPI;
import com.sivalabs.bookstore.catalog.Product;
import com.sivalabs.bookstore.orders.CreateOrderRequest;
import com.sivalabs.bookstore.orders.CreateOrderResponse;
import com.sivalabs.bookstore.orders.InvalidOrderException;
import com.sivalabs.bookstore.orders.OrderDTO;
import com.sivalabs.bookstore.orders.OrderStatus;
import com.sivalabs.bookstore.orders.OrdersAPI;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
class OrderService implements OrdersAPI {
    private final OrderRepository orderRepository;
    private final CatalogAPI catalogAPI;

    OrderService(OrderRepository orderRepository, CatalogAPI catalogAPI) {
        this.orderRepository = orderRepository;
        this.catalogAPI = catalogAPI;
    }

    @Override
    public Optional<OrderDTO> findOrder(String orderNumber) {
        return this.orderRepository.findByOrderNumber(orderNumber);
    }

    @Override
    public List<OrderDTO> findOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Transactional
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        this.validateOrderRequest(request);
        return orderRepository.createOrder(request);
    }

    private void validateOrderRequest(CreateOrderRequest req) {
        req.items().forEach(item -> {
            Product product = catalogAPI
                    .findProductByCode(item.code())
                    .orElseThrow(() -> new InvalidOrderException("Invalid Product Code: " + item.code()));
            if (product.price().compareTo(item.price()) != 0) {
                throw new InvalidOrderException("Product price mismatch for code: " + item.code());
            }
        });
    }
}

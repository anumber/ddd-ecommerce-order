package com.ecommerce.order.adapter.transport;

import com.ecommerce.order.domain.model.Order;
import com.ecommerce.order.domain.model.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> orders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order orders(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
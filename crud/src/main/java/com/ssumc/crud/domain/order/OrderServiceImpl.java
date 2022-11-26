package com.ssumc.crud.domain.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public int save(Order order) {
        orderRepository.save(order);
        return order.getOrderId();
    }

    @Override
    public Optional<Order> findByOrder(int orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Order order) {

    }
}

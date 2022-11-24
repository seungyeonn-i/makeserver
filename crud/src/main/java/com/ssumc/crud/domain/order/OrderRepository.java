package com.ssumc.crud.domain.order;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findByOrderId(int orderId);

    List<Order> findAllByUserId(int userId);

    List<Order> findAll();
}

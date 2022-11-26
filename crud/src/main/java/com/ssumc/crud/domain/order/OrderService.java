package com.ssumc.crud.domain.order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    int save(Order order);

    Optional<Order> findByOrder(int orderId);

    List<Order> findAll();

    void delete(Order order);

}

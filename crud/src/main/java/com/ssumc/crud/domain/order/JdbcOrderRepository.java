package com.ssumc.crud.domain.order;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcOrderRepository implements OrderRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findByBillId(int orderId) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAllByUserId(int userId) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}

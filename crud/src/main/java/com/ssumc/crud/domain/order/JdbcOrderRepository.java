package com.ssumc.crud.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    // TODO : bean 확인
    public JdbcOrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Order save(Order order) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("Order").usingGeneratedKeyColumns("orderId");
        return order;
    }

    @Override
    public Optional<Order> findByOrderId(int orderId) {
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

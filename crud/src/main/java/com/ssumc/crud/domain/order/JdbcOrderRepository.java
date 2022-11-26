package com.ssumc.crud.domain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class JdbcOrderRepository implements OrderRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Order save(Order order) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("_Order").usingGeneratedKeyColumns("orderId");

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("orderId", order.getOrderId());
        parameters.put("userId", order.getUserId());
        parameters.put("storeId", order.getStoreId());
        parameters.put("bucketId", order.getBucketId());
        parameters.put("totalPrice", order.getTotalPrice());
        parameters.put("toAddress", order.getToAddress());
        parameters.put("storeMessage", order.getStoreMessage());
        parameters.put("riderMessage", order.getRiderMessage());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        order.setOrderId(key.intValue());

        return order;
    }

    @Override
    public Optional<Order> findByOrderId(int orderId) {

        List<Order> result = jdbcTemplate.query("select * from _Order where orderId = ? ", orderRowMapper(), orderId);

        return Optional.ofNullable(result.get(0)); // TODO : warning :: get index
//        return null;
//        return result.stream().findFirst();
    }

    @Override
    public List<Order> findAllByUserId(int userId) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query("select * from _Order", orderRowMapper());
    }

    private RowMapper<Order> orderRowMapper() {
        return (rs,rowNum) -> {
            Order order = new Order();
            order.setOrderId(rs.getInt("orderId"));
            order.setStoreId(rs.getInt("storeId"));
            order.setBucketId(rs.getInt("bucketId"));

            order.setTotalPrice(rs.getInt("totalPrice"));
            order.setToAddress(rs.getString("toAddress"));
            order.setStoreMessage(rs.getString("storeMessage"));
            order.setRiderMessage(rs.getString("riderMessage"));
            return order;
        };
    }
}

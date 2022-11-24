package com.ssumc.crud.domain.item;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcItemRepository implements ItemRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcItemRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Item save(Item item) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("Item").usingGeneratedKeyColumns("itemId");

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("storeId", item.getStoreId());
        parameters.put("itemName", item.getItemName());
        parameters.put("itemPrice", item.getItemPrice());
        parameters.put("itemDetails", item.getItemDetails());
        parameters.put("itemPhotoUrl", item.getItemPhotoUrl());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        item.setItemId(key.intValue());

        return item;
    }

    @Override
    public Optional<Item> findByStoreId(int storeId) {
        return Optional.empty();
    }

    @Override
    public Optional<Item> findByItemPrice(int itemPrice) {
        return Optional.empty();
    }



    @Override
    public List<Item> findAll() {
        return jdbcTemplate.query("select * from Item", itemRowMapper());
    }

    @Override
    public List<Item> findAllByStoreId(int storeId) {
        return jdbcTemplate.query("select * from Item where itemId = ?", itemRowMapper(), storeId);
    }

    @Override
    public List<Item> findAllByItemPrice(int itemPrice) {
        return jdbcTemplate.query("select * from Item where itemPrice = ? ", itemRowMapper(), itemPrice);
    }

    @Override
    public void itemDelete(Item item) {

    }

    private RowMapper<Item> itemRowMapper() {
        return (rs, rowNum) -> {
            Item item = new Item();
            item.setItemName(rs.getString("itemName"));
            item.setItemPrice(rs.getInt("itemPrice"));
            item.setItemDetails(rs.getString("itemDetails"));
            item.setItemPhotoUrl(rs.getString("itemPhotoUrl"));
            return item;
        };
    }
}

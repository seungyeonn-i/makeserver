package com.ssumc.crud.domain.item;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
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
    public void itemDelete(Item item) {

    }
}

package com.ssumc.crud.domain.item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    int save(Item item);

    List<Item> findByStore(int storeId);

    List<Item> findByPrice(int itemPrice, int start, int end);

    Optional<Item> findByItemName(String itemName);

    Optional<Item> findOne(int itemId);

    List<Item> findAll();

    void delete(Item item);
}

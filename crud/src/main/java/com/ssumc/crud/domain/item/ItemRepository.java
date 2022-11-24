package com.ssumc.crud.domain.item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    Optional<Item> findByStoreId(int storeId);

    Optional<Item> findByItemName(String itemName);

    List<Item> findByItemPrice(int itemPrice,int start, int end);

    Optional<Item> findByItemId(int itemId);

    List<Item> findAll();

    List<Item> findAllByStoreId(int storeId);

    List<Item> findAllByItemPrice(int itemPrice);

    void itemDelete(Item item);
}

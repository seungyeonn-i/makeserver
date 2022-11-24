package com.ssumc.crud.domain.item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    Optional<Item> findByStoreId(int storeId);

    Optional<Item> findByItemPrice(int itemPrice);

    List<Item> findAll();

    List<Item> findAllByStoreId(int storeId);

    List<Item> findAllByItemPrice(int itemPrice);

    void itemDelete(Item item);
}

package com.ssumc.crud.domain.item;

import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    Optional<Item> findByStoreId(int storeId);

    Optional<Item> findByItemPrice(int itemPrice);

    void itemDelete(Item item);
}

package com.ssumc.crud.domain.item;

import java.util.Optional;

public interface ItemService {
    int save(Item item);

    Optional<Item> sortByStore(int storeId);

    Optional<Item> sortByPrice(int itemPrice);

    void delete(Item item);
}

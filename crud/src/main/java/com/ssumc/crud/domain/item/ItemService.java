package com.ssumc.crud.domain.item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    int save(Item item);

    List<Item> sortByStore(int storeId);

    List<Item> sortByPrice(int itemPrice);

    void delete(Item item);
}

package com.ssumc.crud.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public int save(Item item) {
        return 0;
    }

    @Override
    public Optional<Item> sortByStore(int storeId) {
        return Optional.empty();
    }

    @Override
    public Optional<Item> sortByPrice(int itemPrice) {
        return Optional.empty();
    }

    @Override
    public void delete(Item item) {

    }
}

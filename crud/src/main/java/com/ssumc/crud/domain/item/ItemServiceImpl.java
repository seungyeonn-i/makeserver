package com.ssumc.crud.domain.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public int save(Item item) {

        log.info(item.toString());
        itemRepository.save(item);
        return item.getItemId();
    }

    @Override
    public List<Item> sortByStore(int storeId) {
        return itemRepository.findAllByStoreId(storeId);

        // TODO 가격 순 sort
    }

    @Override
    public List<Item> sortByPrice(int itemPrice) {
        return itemRepository.findAllByItemPrice(itemPrice);

    }

    @Override
    public void delete(Item item) {

    }
}

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
    public List<Item> sortByPrice(int itemPrice,int start, int end) {
//        return itemRepository.findAllByItemPrice(itemPrice);
        // TODO 가격 사이
        return itemRepository.findByItemPrice(itemPrice, start, end);
    }

    @Override
    public Optional<Item> findOne(int itemId) {
        return itemRepository.findByItemId(itemId);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }


    @Override
    public void delete(Item item) {

    }
}

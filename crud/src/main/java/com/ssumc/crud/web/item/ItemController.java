package com.ssumc.crud.web.item;

import com.ssumc.crud.domain.config.BaseResponse;
import com.ssumc.crud.domain.item.Item;
import com.ssumc.crud.domain.item.ItemService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/items/new")
    public String addItem(@ModelAttribute("item") Item item, RedirectAttributes redirectAttributes) {
        Item item1 = new Item();
        item1.setStoreId(item.getStoreId());
        item1.setItemName(item.getItemName());
        item1.setItemPrice(item.getItemPrice());
        item1.setItemDetails(item.getItemDetails());
        item1.setItemPhotoUrl(item.getItemPhotoUrl());
        itemService.save(item);

        return "redirect:/";
    }


    @ResponseBody
    @PostMapping (value = "/items/findPrice")
    public BaseResponse<List<Item>> findByPriceV3(int start, int end) {
        List<Item> byPrice = itemService.findByPrice(20000, start, end);

        return new BaseResponse<>(byPrice);
    }


    @ResponseBody
    @PostMapping(value = "/items/findName")
    public BaseResponse<Item> findByNameV3(String name) {
        Item byItemName = itemService.findByItemName(name).get();

        return new BaseResponse<>(byItemName);
    }

}

package com.ssumc.crud.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@Data
public class Item {

    private int itemId;

    private int storeId;

    private String itemName;
    private int itemPrice;
    private String itemDetails;
    private String itemPhotoUrl;
}

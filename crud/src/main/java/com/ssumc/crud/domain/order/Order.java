package com.ssumc.crud.domain.order;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {

    private int orderId;
    private int userId;
    private int storeId;
    private int bucketId;

    private int totalPrice;
    private String toAddress;
    private String storeMessage;
    private String riderMessage;


}

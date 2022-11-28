package com.ssumc.crud.web.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class GetUserRes {

    private int userId;
    private String userEmail;
    private String userName;
}

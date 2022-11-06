package com.ssumc.crud.domain;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class User {


    private int userId;
    private String password;
    private String userEmail;
    private String userPhone;
    private char userStatus;
    private char userGrade;
    private String userName;


}

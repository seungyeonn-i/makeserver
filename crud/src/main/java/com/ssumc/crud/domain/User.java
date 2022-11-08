package com.ssumc.crud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Entity
@Getter @Setter
public class User {

    private int userId;
    private String userName;
    private String password;
    private String userEmail;
    private String userPhone;
    private char userStatus;
    private char userGrade;

}

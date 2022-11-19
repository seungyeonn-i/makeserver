package com.ssumc.crud.domain.user;

import lombok.Getter;
import lombok.Setter;



//@Entity
@Getter @Setter
public class User {


//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private String userEmail;
    private String userPhone;
    private char userStatus;
    private char userGrade;

}

package com.ssumc.crud.domain.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


//@Entity
@Getter @Setter
@Data
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

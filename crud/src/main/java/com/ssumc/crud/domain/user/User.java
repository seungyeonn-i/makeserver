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
    @NotBlank
    private int userId;
    @NotBlank
    private String userName;
    @NotBlank
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;
    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    private String userPhone;

    private char userStatus;
    private char userGrade;

}

package com.ssumc.crud.web.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter @Setter
@AllArgsConstructor // 해당 클래스의 모든 멤버 변수(jwt, userIdx)를 받는 생성자를 생성-
public class UserRes {
    private int userId;



}

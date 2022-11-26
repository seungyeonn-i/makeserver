package com.ssumc.crud.web.login;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginReq {
    private String loginEmail;
    private String password;
}

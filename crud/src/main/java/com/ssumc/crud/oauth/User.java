package com.ssumc.crud.oauth;

import lombok.*;

import java.sql.Timestamp;

@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private Long userId;
    private String userName;

    private String password;
    private String userEmail;

    private Role role;
    private Timestamp createTime;

    private String provider;
    private String providerId;

    @Builder(builderClassName = "OAuth2Register",builderMethodName = "oauth2Register")
    public User(String userName, String password, String userEmail, Role role, String provider, String providerId) {
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}

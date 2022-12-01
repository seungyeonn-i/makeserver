package com.ssumc.crud.web.auth;

public interface UserRepository {
    User findByUserId(String userId);
}

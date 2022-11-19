package com.ssumc.crud.domain.user;

import com.ssumc.crud.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    int join(User user);

    List<User> findUsers();

    Optional<User> findOne(int userId);
}

package com.ssumc.crud.service;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserService;
import com.ssumc.crud.domain.user.UserServiceImpl;
import com.ssumc.crud.domain.repository.MemoryUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    UserService userService;
    MemoryUserRepository userRepository;

    @BeforeEach
    public void beforeEach() {
        userRepository = new MemoryUserRepository();
//        userService = new UserServiceImpl(userRepository);
    }

    @AfterEach
    public void afterEach() {
        userRepository.clearStore();
    }

    @Test
    public void join() throws Exception {
        User user = new User();
        user.setUserName("user1");
        user.setUserId(3);

//        int savedId = userService.join(user);

        User findUser = userRepository.findById(3).get();
        assertEquals(user.getUserName(), findUser.getUserName());
    }
}

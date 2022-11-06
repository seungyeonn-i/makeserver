package com.ssumc.crud;

import com.ssumc.crud.repository.MemoryUserRepository;
import com.ssumc.crud.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class UserServiceTest {
    UserService userService;
    MemoryUserRepository memoryUserRepository;

    @BeforeEach
    public void beforeEach() {
        memoryUserRepository = new MemoryUserRepository();
        userService = new UserService(memoryUserRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryUserRepository.clearStore();
    }
}

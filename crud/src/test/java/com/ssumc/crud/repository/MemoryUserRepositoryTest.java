package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryUserRepositoryTest {
    MemoryUserRepository repository = new MemoryUserRepository();


    @AfterEach
    public void afterEach() {
        repository.clearStore();

    }

    @Test
    public void save() {
        User user = new User();
        user.setUserName("test1");
        user.setUserId(1);

        repository.save(user);

        User result = repository.findById(user.getUserId()).get();
        assertThat(result).isEqualTo(user);
    }

    @Test
    public void findById() {
        User user1 = new User();
        user1.setUserName("spring1");
        user1.setUserId(1);
        repository.save(user1);

        User user2 = new User();
        user2.setUserName("spring2");
        user1.setUserId(2);

        repository.save(user2);

        User result = repository.findById(1).get();
        assertThat(result).isEqualTo(user1);
    }

    @Test
    public void findAll() {
        User user1 = new User();
        user1.setUserName("spring1");
        user1.setUserId(1);
        repository.save(user1);

        User user2 = new User();
        user2.setUserName("spring2");
        user1.setUserId(2);

        repository.save(user2);

        List<User> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

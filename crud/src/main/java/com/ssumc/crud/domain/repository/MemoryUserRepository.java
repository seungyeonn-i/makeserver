package com.ssumc.crud.domain.repository;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository   {

    private static Map<Integer, User> store = new HashMap<>();


    public User save(User user) {
        store.put(user.getUserId(), user);
        return user;
    }


    public Optional<User> findById(int userId) {
        return Optional.ofNullable(store.get(userId));
    }


    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }


    public Optional<User> findByUserEmail(String userEmail) {
        return findAll().stream()
                .filter(m -> m.getUserEmail().equals(userEmail))
                .findFirst();
    }

    public void clearStore() {
        store.clear();

    }
}

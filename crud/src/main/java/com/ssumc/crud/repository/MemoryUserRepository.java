package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository {

    private static Map<Integer, User> store = new HashMap<>();

    @Override
    public User save(User user) {
        store.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(int userId) {
        return Optional.ofNullable(store.get(userId));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();

    }
}

package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
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

    @Override
    public Optional<User> findByUserEmail(String userEmail) {
        return findAll().stream()
                .filter(m -> m.getUserEmail().equals(userEmail))
                .findFirst();
    }

    public void clearStore() {
        store.clear();

    }
}

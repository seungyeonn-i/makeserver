package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements UserRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> findById(int userId) {
        User user = em.find(User.class, userId);
        return Optional.ofNullable(user);
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}

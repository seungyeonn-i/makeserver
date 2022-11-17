package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository {
    User save(User user);

    Optional<User> findById(int userId);

    Optional<User> findByUserEmail(String userEmail);

    List<User> findAll();

}

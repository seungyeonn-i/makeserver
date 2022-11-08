package com.ssumc.crud.repository;

import com.ssumc.crud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Integer>, UserRepository {

    @Override
    Optional<User> findById(int userId);

}

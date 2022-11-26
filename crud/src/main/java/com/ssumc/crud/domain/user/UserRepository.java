package com.ssumc.crud.domain.user;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.web.user.UserReq;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository {
    int save(UserReq userReq);

    Optional<User> findById(int userId);

    Optional<User> findByUserEmail(String userEmail);

    List<User> findAll();

}

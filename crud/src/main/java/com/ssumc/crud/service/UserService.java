package com.ssumc.crud.service;

import com.ssumc.crud.domain.User;
import com.ssumc.crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

//    private final UserRepository userRepository = new ;

    private final UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public int join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(int userId) {
        return userRepository.findById(userId);
    }
}

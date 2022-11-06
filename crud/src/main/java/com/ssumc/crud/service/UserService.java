package com.ssumc.crud.service;

import com.ssumc.crud.domain.User;
import com.ssumc.crud.repository.JdbcUserRepository;
import com.ssumc.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final JdbcUserRepository userRepository ;


    public UserService(JdbcUserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    public int join(User user) {
//        userRepository.save(user);
//        return user.getUserId();
//    }

    public int join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    public  List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(int userId) {
        return userRepository.findById(userId);
    }
}

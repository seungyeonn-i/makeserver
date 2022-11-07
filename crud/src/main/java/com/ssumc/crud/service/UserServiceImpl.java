//package com.ssumc.crud.service;
//
//import com.ssumc.crud.domain.User;
//import com.ssumc.crud.repository.MemoryUserRepository;
//import com.ssumc.crud.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements  UserService {
//
//
//    private final UserRepository userRepository = new MemoryUserRepository();
//
//
//    public void join(User user) {
//        userRepository.save(user);
//    }
//
//    public  List<User> findUsers() {
//        return userRepository.findAll();
//    }
//
//    public User findOne(int userId) {
//        return userRepository.findById(userId);
//    }
//}

package com.ssumc.crud.service;

import com.ssumc.crud.domain.User;
import com.ssumc.crud.repository.MemoryUserRepository;
import com.ssumc.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class UserServiceImpl implements  UserService {


    private final UserRepository userRepository ;

    //회원 서비스 코드를 DI 가능하게 변경한다. Dependency Injection
    // UserRepository interface로 파라미터 받기 때문에
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



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

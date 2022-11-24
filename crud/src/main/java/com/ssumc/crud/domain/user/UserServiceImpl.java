package com.ssumc.crud.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository ;

    //회원 서비스 코드를 DI 가능하게 변경한다. Dependency Injection
    // UserRepository interface로 파라미터 받기 때문에
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public int join(User user) {

//        if (validatePasswordUser(user)) {
            userRepository.save(user);
            return user.getUserId();
//        }
//        return -1;

    }

    private boolean validatePasswordUser(User user) {
        return user.getPassword().contains("!");
    }

    public  List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(int userId) {
        return userRepository.findById(userId);
    }
}

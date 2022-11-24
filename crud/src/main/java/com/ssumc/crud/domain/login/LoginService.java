package com.ssumc.crud.domain.login;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository ;

    public User login(String userEmail, String password) {


//        log.info(userRepository.findByUserEmail(userEmail).get().toString());
        //
        log.info(userRepository.findAll().toString());

        return userRepository.findByUserEmail(userEmail)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}

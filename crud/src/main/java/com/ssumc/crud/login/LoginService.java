package com.ssumc.crud.login;

import com.ssumc.crud.domain.User;
import com.ssumc.crud.repository.JdbcUserRepository;
import com.ssumc.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository ;

    public User login(String userEmail, String password) {
        return userRepository.findByUserEmail(userEmail)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}

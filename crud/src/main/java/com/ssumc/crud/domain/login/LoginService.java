package com.ssumc.crud.domain.login;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
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

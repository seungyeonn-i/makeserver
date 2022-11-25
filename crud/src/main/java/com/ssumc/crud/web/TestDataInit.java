package com.ssumc.crud.web;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {

//        User user = new User();
//        user.setUserEmail("aaa@aaa.com");
//        user.setPassword("test!");
//
//        userRepository.save(user);
    }


}

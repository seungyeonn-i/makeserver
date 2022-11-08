package com.ssumc.crud;

import com.ssumc.crud.repository.JdbcUserRepository;
import com.ssumc.crud.repository.JpaUserRepository;
import com.ssumc.crud.repository.MemoryUserRepository;
import com.ssumc.crud.repository.UserRepository;
import com.ssumc.crud.service.UserService;
import com.ssumc.crud.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final UserRepository userRepository;

    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository);
    }
//
//    @Bean
//    public UserRepository userRepository() {
////        return new MemoryUserRepository();
//        return new JpaUserRepository(em);
//    }
}

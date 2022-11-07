//package com.ssumc.crud;
//
//import com.ssumc.crud.repository.JdbcUserRepository;
//import com.ssumc.crud.repository.UserRepository;
//import com.ssumc.crud.service.UserServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SpringConfig {
//
//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public UserServiceImpl userService() {
//        return new UserServiceImpl(userRepository());
//    }
//
//    @Bean
//    public UserRepository userRepository() {
//        return new JdbcUserRepository(dataSource);
//    }
//}

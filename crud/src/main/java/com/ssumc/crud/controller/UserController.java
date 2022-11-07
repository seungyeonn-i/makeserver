//package com.ssumc.crud.controller;
//
//import com.ssumc.crud.domain.User;
//import com.ssumc.crud.service.UserServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//public class UserController {
//
//    private final UserServiceImpl userServiceImpl;
//
//    public UserController(UserServiceImpl userServiceImpl) {
//        this.userServiceImpl = userServiceImpl;
//    }
//
//    @PostMapping("/join")
//    public Object userJoin() {
//        log.debug("/userJoin start");
//        List<User> userList = userServiceImpl.findUsers();
//        log.debug(userList.toString());
//
//        User user = new User();
//        user.setUserEmail("aaa");
//        user.setUserPhone("3234");
//        user.setUserName("seungo");
//        user.setPassword("hello");
//
//        user.setUserStatus('1');
//        user.setUserGrade('1');
//        userServiceImpl.join(user);
//
//        return userList;
//
//    }
//}

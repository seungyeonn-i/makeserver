package com.ssumc.crud.web.user;

import com.ssumc.crud.domain.config.BaseException;
import com.ssumc.crud.domain.config.BaseResponse;
import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @Autowired
//    public UserController(UserServiceImpl userServiceImpl) {
//        this.userService = userServiceImpl;
//    }

    @GetMapping(value = "/users/new")
    public String createForm(Model model) {
        model.addAttribute("user", new UserReq());

        return "users/createUserForm";
    }


    @PostMapping(value = "/users/new")
    public String createUser(@Validated @ModelAttribute("user") UserReq userReq, BindingResult result, RedirectAttributes redirectAttributes) throws BaseException {
        if (result.hasErrors()) {
            log.info("errors={}", result);
            return "users/createUserForm";
        }
        userService.join(userReq);

//        redirectAttributes.addAttribute("user", user);
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/signUp")
    public BaseResponse<UserRes> signUpUser(@RequestBody UserReq userReq) {
        try {
            UserRes userRes = userService.join(userReq);
            return new BaseResponse<>(userRes);
        } catch (BaseException e) {
            return new BaseResponse<>((e.getStatus()));
        }
    }

//
//    @GetMapping(value = "/users")
//    public String list(Model model) {
//        List<GetUserRes> users = userService.findUsers();
//        model.addAttribute("users", users);
//        return "users/userList";
//    }

    @ResponseBody
    @GetMapping(value = "/admin/users")
    public BaseResponse<List<GetUserRes>> userList() {

        List<GetUserRes> users = userService.findUsers();
        return new BaseResponse<>(users);

    }
}

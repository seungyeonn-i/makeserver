package com.ssumc.crud.web.user;

import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserService;
import com.ssumc.crud.domain.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping(value = "/users/new")
    public String createForm(Model model) {
        model.addAttribute("user", new UserForm());

        return "users/createUserForm";
    }

    @PostMapping(value = "/users/new")
    public String create(@Validated @ModelAttribute("user") UserForm form, BindingResult result,RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            log.info("errors={}", result);
            return "users/createUserForm";
        }

        User user = new User();
        user.setUserName(form.getUserName());
        user.setPassword(form.getPassword());
        user.setUserPhone(form.getUserPhone());

        user.setUserEmail(form.getUserEmail());
        userService.join(user);

//        redirectAttributes.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/users")
    public String list(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }



}

package com.ssumc.crud.web;


import com.ssumc.crud.SessionConst;
import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
import com.ssumc.crud.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    private final SessionManager sessionManager;

    @GetMapping("/")
    public String homeLogin(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser, Model model) {
        if (loginUser == null) {
            return "home";
        }
        model.addAttribute("user", loginUser);
        return "loginHome";
    }
}

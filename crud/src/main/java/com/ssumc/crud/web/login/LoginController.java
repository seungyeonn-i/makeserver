package com.ssumc.crud.web.login;

import com.ssumc.crud.domain.config.BaseException;
import com.ssumc.crud.domain.config.BaseResponse;
import com.ssumc.crud.session.SessionConst;
import com.ssumc.crud.domain.login.LoginService;
import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        return "login/loginForm";
    }

    /**
     * 웹 연결 OK, BindingResult 적용 안됨
     */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm form, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "login/loginForm";
        }

        User loginUser = loginService.login(form.getLoginEmail(), form.getPassword());

        if (loginUser == null) {
            result.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);

        return "redirect:/";
    }

    /**
     * API
     */

    @ResponseBody
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse<LoginRes> loginJson(@RequestBody LoginReq loginReq) {
        try {
            LoginRes loginRes = loginService.login(loginReq);
            return new BaseResponse<>(loginRes);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }    @ResponseBody
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public BaseResponse<LoginRes> loginForm( LoginReq loginReq) {
        try {
            LoginRes loginRes = loginService.login(loginReq);
            return new BaseResponse<>(loginRes);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }





    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 불필요한 세션 만들지 않음
        if (session != null) { // 로그인 되어있는 경우
            session.invalidate();
        }
        return "redirect:/";
    }
}

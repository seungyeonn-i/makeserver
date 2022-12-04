package com.ssumc.crud.domain.login;

import com.ssumc.crud.domain.config.BaseException;
import com.ssumc.crud.domain.config.BaseResponseStatus;
import com.ssumc.crud.domain.jwt.AES128;
import com.ssumc.crud.domain.jwt.config.secret.Secret;
import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.domain.user.UserRepository;
import com.ssumc.crud.web.login.LoginReq;
import com.ssumc.crud.web.login.LoginRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository ;

    public User login(String userEmail, String password) {


//        log.info(userRepository.findByUserEmail(userEmail).get().toString());
        //
        log.info(userRepository.findAll().toString());

        return userRepository.findByUserEmail(userEmail)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }


    public LoginRes login(LoginReq loginReq) throws BaseException {
        User user = userRepository.findByUserEmail(loginReq.getLoginEmail()).get();

        String pwd;
        try{
            pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(user.getPassword());
        }catch (Exception e){
            throw new BaseException(BaseResponseStatus.PASSWORD_DECRYPTION_ERROR);
        }

        System.out.println(user.getPassword());
        System.out.println(loginReq.getPassword());
        System.out.println(pwd);

        if (loginReq.getPassword().equals(pwd)) {
            int loginId = userRepository.findByUserEmail(loginReq.getLoginEmail()).get().getUserId();
            return new LoginRes(loginId);
        } else{
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }

    }

}

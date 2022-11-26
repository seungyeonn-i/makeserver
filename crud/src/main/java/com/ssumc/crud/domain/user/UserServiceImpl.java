package com.ssumc.crud.domain.user;

import com.ssumc.crud.domain.config.BaseException;
import com.ssumc.crud.domain.config.BaseResponseStatus;
import com.ssumc.crud.domain.jwt.AES128;
import com.ssumc.crud.domain.jwt.config.secret.Secret;
import com.ssumc.crud.web.user.UserReq;
import com.ssumc.crud.web.user.UserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ssumc.crud.domain.config.BaseResponseStatus.DATABASE_ERROR;

//@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository ;

    //회원 서비스 코드를 DI 가능하게 변경한다. Dependency Injection
    // UserRepository interface로 파라미터 받기 때문에
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public UserRes join(UserReq userReq) throws BaseException {

//        if (validatePasswordUser(user)) {
        String pwd;

        try {
            // 비밀번호 암호화 하여 저장
            pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(userReq.getPassword());
            userReq.setPassword(pwd);
        } catch (Exception e) { // 암호화 실패했을 경우 에러
            throw new BaseException(BaseResponseStatus.PASSWORD_DECRYPTION_ERROR);
        }
        try {
            int saveId = userRepository.save(userReq);
            return new UserRes(saveId);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }

//        return -1;

    }

    private boolean validatePasswordUser(User user) {
        return user.getPassword().contains("!");
    }

    public  List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(int userId) {
        return userRepository.findById(userId);
    }
}

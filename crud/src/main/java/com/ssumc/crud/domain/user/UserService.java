package com.ssumc.crud.domain.user;

import com.ssumc.crud.domain.config.BaseException;
import com.ssumc.crud.domain.user.User;
import com.ssumc.crud.web.user.GetUserRes;
import com.ssumc.crud.web.user.UserReq;
import com.ssumc.crud.web.user.UserRes;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserRes join(UserReq userReq) throws BaseException;

    List<GetUserRes> findUsers();

    Optional<User> findOne(int userId);
}

package com.ssumc.crud.domain.jwt;


import com.ssumc.crud.domain.jwt.config.BaseException;

import java.util.Date;

public interface JwtService {

     String createJwt(int userId);

     String getJwt();

     int getUserId() throws BaseException;
}

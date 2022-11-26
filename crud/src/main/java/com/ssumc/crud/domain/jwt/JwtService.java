package com.ssumc.crud.domain.jwt;


import com.ssumc.crud.domain.config.BaseException;

public interface JwtService {

     String createJwt(int userId);

     String getJwt();

     int getUserId() throws BaseException;
}

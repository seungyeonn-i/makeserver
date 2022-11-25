package com.ssumc.crud.domain.jwt;

import com.ssumc.crud.domain.jwt.config.BaseException;
import com.ssumc.crud.domain.jwt.config.BaseResponseStatus;
import com.ssumc.crud.domain.jwt.config.secret.Secret;
import io.jsonwebtoken.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.ssumc.crud.domain.jwt.config.BaseResponseStatus.EMPTY_JWT;
import static com.ssumc.crud.domain.jwt.config.BaseResponseStatus.INVALID_JWT;

public class JwtServiceImpl implements JwtService {

    @Override
    public String createJwt(int userId) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 60 * 24 * 365)))
                .signWith(SignatureAlgorithm.HS256, Secret.JWT_SECRET_KEY)
                .compact();
    }


    @Override
    public String getJwt() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("X-ACCESS_TOKEN");
    }

    @Override
    public int getUserId() throws BaseException {

        String accessToken = getJwt();
        if (accessToken == null || accessToken.length() == 0) {
            throw new BaseException(EMPTY_JWT);
        }

        Jws<Claims> claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(Secret.JWT_SECRET_KEY)
                    .parseClaimsJws(accessToken);
        } catch (ExpiredJwtException ignored) {
            throw new BaseException(INVALID_JWT);
        }

        return claims.getBody().get("userId", Integer.class);
    }
}

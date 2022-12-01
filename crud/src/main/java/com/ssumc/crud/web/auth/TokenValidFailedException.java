package com.ssumc.crud.web.auth;

import io.jsonwebtoken.Claims;

public class TokenValidFailedException extends RuntimeException {

    public TokenValidFailedException() {
        super("Failed to generate Token.");
    }

    private TokenValidFailedException(String message) {
        super(message); // super 클래스 (Runtime Exception 에 전달)
        //  super의 super의 ... throwable에서 fillInStackTrace();
        //        detailMessage = message;
    }

    Claims
}

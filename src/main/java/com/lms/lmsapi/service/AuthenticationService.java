package com.lms.lmsapi.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;

import com.lms.lmsapi.auth.ApiKeyAuthentication;

import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationService {

    private static final String AUTH_TOKEN_HEADER_NAME = "LMS-API-KEY";
    private static final String AUTH_TOKEN = "lmsapivalue";

    public static ApiKeyAuthentication getAuthentication(HttpServletRequest request) 
    {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) 
        {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
package com.jey.skillup.service;

import com.jey.skillup.request.AuthenticationRequest;
import com.jey.skillup.request.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    public void register(RegisterRequest input, String role) throws Exception;
    public void login(AuthenticationRequest request, HttpServletRequest httpRequest);
    public void logout(HttpServletRequest request);
}

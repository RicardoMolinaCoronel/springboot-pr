package com.ricardo.practica2.controllers;


import com.ricardo.practica2.dto.auth.AuthRequest;
import com.ricardo.practica2.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final JwtUtils jwtUtils;
    private AuthenticationManager authenticationManager;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest authRequest){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        String token = jwtUtils.generateToken(authRequest.getUsername());
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return map;
    }

    @GetMapping("/userGitHub")
    public Map<String, Object> userGitHhub(@AuthenticationPrincipal OAuth2User principal){
            return principal.getAttributes();

    }

}

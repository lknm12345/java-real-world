package com.example.accessingdatajpa.user.controller;

import com.example.accessingdatajpa.user.dto.UserLoginResponse;
import com.example.accessingdatajpa.user.entity.User;
import com.example.accessingdatajpa.user.dto.UserLoginDto;
import com.example.accessingdatajpa.user.dto.UserRegisterDto;
import com.example.accessingdatajpa.user.dto.UserUpdateDto;
import com.example.accessingdatajpa.user.service.AuthService;
import com.example.accessingdatajpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @PostMapping("/users")
    public User Register (@RequestBody UserRegisterDto userRegisterDto) {
        return userService.userRegister(userRegisterDto);
    };

    @PostMapping("/users/login")
    public UserLoginResponse LoginAndRememberToken (@RequestBody UserLoginDto userLoginDto) {
        return authService.getToken(userLoginDto.getEmail(), userLoginDto.getPassword());
    }

    @GetMapping("/user")
    public User CurrentUser () {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userService.getUserByEmail(authentication.getName());
    }

    @PutMapping("/user")
    public void UpdateUser (@RequestBody UserUpdateDto userUpdateDto) {
    }
}

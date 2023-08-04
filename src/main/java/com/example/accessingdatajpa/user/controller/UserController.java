package com.example.accessingdatajpa.user.controller;

import com.example.accessingdatajpa.user.entity.User;
import com.example.accessingdatajpa.user.dto.UserLoginDto;
import com.example.accessingdatajpa.user.dto.UserRegisterDto;
import com.example.accessingdatajpa.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/api/users")
    public User signUp(@RequestBody UserRegisterDto request, HttpServletRequest httpServletRequest) {
        return userService.userRegister(request);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/api/users/login")
    public User login(@RequestBody UserLoginDto request) {
        return userService.login(request);
    }

    @GetMapping("/api/user")
    public User getCurrentUser(User me) {
        return me;
    }

    @PutMapping("/api/user")
    public User updateCurrentUser(User me) {
        return me;
    }
}

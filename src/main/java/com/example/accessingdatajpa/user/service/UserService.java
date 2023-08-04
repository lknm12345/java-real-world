package com.example.accessingdatajpa.user.service;

import com.example.accessingdatajpa.config.BearerTokenProvider;
import com.example.accessingdatajpa.user.dto.UserLoginDto;
import com.example.accessingdatajpa.user.dto.UserRegisterDto;
import com.example.accessingdatajpa.user.dto.UserUpdateDto;
import com.example.accessingdatajpa.user.entity.User;
import com.example.accessingdatajpa.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BearerTokenProvider bearerTokenProvider;


    public User userRegister (UserRegisterDto userRegisterDto) {
        User user = new User();
        userRegisterDto.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        user.registerUser(userRegisterDto);

        return userRepository.save(user);
    }
    public User getUserByEmail (String email) {
        return userRepository.findOneByEmail(email).orElseThrow();
    }

    public User userUpdate (UserUpdateDto userUpdateDto) {
        User user = new User();
        user.updateUser(userUpdateDto);

        return userRepository.save(user);
    }

    public User login(UserLoginDto request) {
        return userRepository
                .findOneByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> {
                    String token = bearerTokenProvider.createBearerToken(user);
                    user.setToken(token);
                    return user;
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
    }

}

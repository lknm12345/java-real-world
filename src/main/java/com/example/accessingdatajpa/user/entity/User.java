package com.example.accessingdatajpa.user.entity;

import com.example.accessingdatajpa.user.dto.UserLoginDto;
import com.example.accessingdatajpa.user.dto.UserRegisterDto;
import jakarta.persistence.*;
import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long user_id;

    private String username;

    private String password;

    private String image;

    private String email;

    @CreatedDate
    private Date created_at;

    private String bio;
    public void registerUser (UserRegisterDto userRegisterDto) {
        this.email = userRegisterDto.getEmail();
        this.password = userRegisterDto.getPassword();
        this.username = userRegisterDto.getUsername();
    }

    public void loginUser (UserLoginDto userLoginDto) {
        this.email = userLoginDto.getEmail();
        this.password = userLoginDto.getPassword();
    }
}


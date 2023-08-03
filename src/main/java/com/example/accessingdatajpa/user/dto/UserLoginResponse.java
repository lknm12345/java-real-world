package com.example.accessingdatajpa.user.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class UserLoginResponse {
    private String accessToken;

    public UserLoginResponse (String accessToken) {
        this.accessToken = accessToken;
    }
}
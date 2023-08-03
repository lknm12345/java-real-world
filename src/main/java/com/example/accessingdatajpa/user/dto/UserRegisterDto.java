package com.example.accessingdatajpa.user.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.Getter;

@Data
@JsonRootName("user")
public class UserRegisterDto {
    private String email;

    private String password;

    private String username;
}

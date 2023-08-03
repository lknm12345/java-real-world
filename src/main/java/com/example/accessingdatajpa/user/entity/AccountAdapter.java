package com.example.accessingdatajpa.user.entity;

import java.util.ArrayList;

public class AccountAdapter extends org.springframework.security.core.userdetails.User {
    private User user;

    public AccountAdapter(User user) {
        super(user.getEmail(), user.getPassword(), new ArrayList<>());
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
package com.example.accessingdatajpa.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowId {
    private Long toUser;

    private Long fromUser;
}

package com.example.accessingdatajpa.user.repository;

import com.example.accessingdatajpa.user.entity.UserFollow;
import com.example.accessingdatajpa.user.entity.UserFollowId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFollowRepository extends JpaRepository<UserFollow, UserFollowId> {
}

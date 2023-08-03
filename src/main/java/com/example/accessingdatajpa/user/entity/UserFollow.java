package com.example.accessingdatajpa.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(UserFollowId.class)
public class UserFollow {
    @Id
    @ManyToOne
    @JoinColumn
    private User toUser;

    @Id
    @ManyToOne
    @JoinColumn
    private User fromUser;

    @CreatedDate
    private Date created_at;
}

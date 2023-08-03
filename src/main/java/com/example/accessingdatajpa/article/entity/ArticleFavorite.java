package com.example.accessingdatajpa.article.entity;

import com.example.accessingdatajpa.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(ArticleFavoriteId.class)
public class ArticleFavorite {
    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @Id
    @ManyToOne
    @JoinColumn
    private Article article;

    @CreatedDate
    private Date created_at;
}

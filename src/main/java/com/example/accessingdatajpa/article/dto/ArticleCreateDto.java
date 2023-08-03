package com.example.accessingdatajpa.article.dto;

import com.example.accessingdatajpa.user.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
public class ArticleCreateDto {
    @ManyToOne
    @JoinColumn
    private User user;

    private String title;

    private String description;

    private String body;
}

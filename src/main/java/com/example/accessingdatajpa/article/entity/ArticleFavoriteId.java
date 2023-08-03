package com.example.accessingdatajpa.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleFavoriteId {
    private Long user;

    private Long article;
}

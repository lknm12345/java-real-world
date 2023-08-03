package com.example.accessingdatajpa.article.repository;

import com.example.accessingdatajpa.article.entity.ArticleFavorite;
import com.example.accessingdatajpa.article.entity.ArticleFavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleFavoriteRepository extends JpaRepository<ArticleFavorite, ArticleFavoriteId> {
}

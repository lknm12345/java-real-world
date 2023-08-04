package com.example.accessingdatajpa.article.repository;

import com.example.accessingdatajpa.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findOneBySlug(String slug);
}

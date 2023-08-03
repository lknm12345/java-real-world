package com.example.accessingdatajpa.article.repository;

import com.example.accessingdatajpa.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

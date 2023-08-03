package com.example.accessingdatajpa.article.repository;

import com.example.accessingdatajpa.article.entity.ArticleTag;
import com.example.accessingdatajpa.article.entity.ArticleTagId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, ArticleTagId> {
}

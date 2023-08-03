package com.example.accessingdatajpa.article.service;

import com.example.accessingdatajpa.article.dto.ArticleCreateDto;
import com.example.accessingdatajpa.article.entity.Article;
import com.example.accessingdatajpa.article.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article articleCreate (ArticleCreateDto articleCreateDto) {
        Article article = new Article();
        article.createArticle(articleCreateDto);

        return articleRepository.save(article);
    }
}

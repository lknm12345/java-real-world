package com.example.accessingdatajpa.article.controller;

import com.example.accessingdatajpa.article.dto.ArticleCreateDto;
import com.example.accessingdatajpa.article.entity.Article;
import com.example.accessingdatajpa.article.service.ArticleService;
import com.example.accessingdatajpa.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/articles")
    public Article articleCreate (@RequestBody ArticleCreateDto articleCreateDto) {
        return articleService.articleCreate(articleCreateDto);
    }

    @GetMapping("/articles/{slug}")
    public Article articleGet (@PathVariable String slug, User user) {
        return articleService.getArticleBySlug(slug);
    }

    @DeleteMapping("/articles/{slug}")
    public void articleDelete (@PathVariable String slug) {

    }
}

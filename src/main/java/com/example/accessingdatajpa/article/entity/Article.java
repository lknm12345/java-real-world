package com.example.accessingdatajpa.article.entity;

import com.example.accessingdatajpa.article.dto.ArticleCreateDto;
import com.example.accessingdatajpa.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    @ManyToOne
    @JoinColumn
    private User author_id;

    @LastModifiedDate
    private Date updated_at;

    private String title;

    private String slug;

    private String description;

    @CreatedDate
    private Date created_at;

    private String body;

    public void createArticle (ArticleCreateDto articleCreateDto) {
        this.title = articleCreateDto.getTitle();
        this.description = articleCreateDto.getDescription();
        this.body = articleCreateDto.getBody();
    }
}

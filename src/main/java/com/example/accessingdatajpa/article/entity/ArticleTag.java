package com.example.accessingdatajpa.article.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(ArticleTagId.class)
public class ArticleTag {
    @Id
    @ManyToOne
    @JoinColumn
    private Tag tag;

    @Id
    @ManyToOne
    @JoinColumn
    private Article article;

    @CreatedDate
    private Date created_at;
}

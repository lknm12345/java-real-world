package com.example.accessingdatajpa.article.repository;

import com.example.accessingdatajpa.article.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

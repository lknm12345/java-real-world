package com.example.accessingdatajpa.article.repository;

import com.example.accessingdatajpa.article.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}

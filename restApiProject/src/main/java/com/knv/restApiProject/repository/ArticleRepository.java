package com.knv.restApiProject.repository;

import com.knv.restApiProject.model.Article;
import com.knv.restApiProject.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

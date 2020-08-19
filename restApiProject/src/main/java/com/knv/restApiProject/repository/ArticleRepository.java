package com.knv.restApiProject.repository;

import com.knv.restApiProject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArticleRepository extends JpaRepository<Article, Long> {
}

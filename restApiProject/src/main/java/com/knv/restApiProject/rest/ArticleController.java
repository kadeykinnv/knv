package com.knv.restApiProject.rest;

import com.knv.restApiProject.model.Article;
import com.knv.restApiProject.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService){this.articleService = articleService;}

    @GetMapping("/articles")
    public List<Article> findAllArticles() {
        return articleService.findAll();
    }

}

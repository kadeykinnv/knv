package com.knv.restApiProject.rest;

import com.knv.restApiProject.model.Article;
import com.knv.restApiProject.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService){this.articleService = articleService;}

    @GetMapping("/articles")
    public List<Article> findAllArticles() {
        return articleService.findAll();
    }

    @GetMapping("/articleById")
    public Article findArticleById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PostMapping("/createArticle")
    public Article saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @RequestMapping(path = "/deleteArticle/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @RequestMapping(path = "/updateArticle", method = RequestMethod.PUT)
    public Article updateArticle(@RequestBody Article article) {return articleService.updateArticle(article); }

    @GetMapping("/sortByArticleName")
    public List<Article> sortByArticleName() {
        return articleService.sortByArticleName();
    }
    @GetMapping("/sortArticlesByDataOfCreate")
    public List<Article> sortByArticlePrice() {
        return articleService.sortByDataOfCreate();
    }
}

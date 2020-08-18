package com.knv.restApiProject.service;

import com.knv.restApiProject.model.Article;
import com.knv.restApiProject.model.Product;
import com.knv.restApiProject.repository.ArticleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class ArticleService  {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Article findById(Long id) {
        return articleRepository.getOne(id);
    }
    public List<Article> findAll( ) {
        return articleRepository.findAll();
    }
    public Article updateArticle(Article article) {
        Article existingArticle = articleRepository.findById(article.getArticleId()).orElse(null);
        existingArticle.setArticleName(article.getArticleName());
        existingArticle.setContent(article.getContent());
        existingArticle.setProduct(article.getProduct());
        return articleRepository.save(existingArticle);
    }
    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public List<Article> sortByArticleName() {
        List<Article> articles = articleRepository.findAll();
        articles.sort(Comparator.comparing(Article::getArticleName));
        return  articles;
    }
    public List<Article> sortByDataOfCreate() {
        List<Article> articles = articleRepository.findAll();
        articles.sort(Comparator.comparing(Article::getTimeOfCreate));
        return articles;
    }

}

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
    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
    public List<Article> sortedByArticleData() {
        List<Article> articles = articleRepository.findAll();
        articles.sort(Comparator.comparing(Article::getTimeOfCreate));
        return articles;
    }

}

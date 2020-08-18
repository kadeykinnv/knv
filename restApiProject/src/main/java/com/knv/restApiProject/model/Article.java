package com.knv.restApiProject.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

@Entity
@Table(name = "articles")
public class Article  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;
    @Column(name = "product_id")
    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="product_id")
    private Product product;
    @Column(name = "article_name")
    private String articleName;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfCreate;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeOfCreate() {
        return timeOfCreate;
    }

    public void setTimeOfCreate(Date timeOfCreate) {
        this.timeOfCreate = timeOfCreate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", productId=" + product +
                ", articleName='" + articleName + '\'' +
                ", content='" + content + '\'' +
                ", timeOfCreate=" + timeOfCreate +
                '}';
    }
}

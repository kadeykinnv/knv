package com.knv.restApiProject.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "specification")
    private String specification;
    @Column(name = "price")
    private Integer price;
    @OneToMany(mappedBy="product", fetch=FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private List<Article> articles;

    public Long getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getSpecification() {
        return specification;
    }
    public void setSpecification(String specification) {
        this.specification = specification;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", product_name='" + productName + '\'' +
                ", specification='" + specification + '\'' +
                ", price=" + price +
                '}';
    }
}

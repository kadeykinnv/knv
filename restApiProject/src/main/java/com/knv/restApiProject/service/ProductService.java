package com.knv.restApiProject.service;

import com.knv.restApiProject.model.Article;
import com.knv.restApiProject.model.Product;
import com.knv.restApiProject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getProductId()).orElse(null);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setSpecification(product.getSpecification());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
    public List<Product> sortByProductName() {
        List<Product> products = productRepository.findAll();
        products.sort(Comparator.comparing(Product::getProductName));
        return  products;
    }
    public List<Product> sortByProductPrice() {
        List<Product> products = productRepository.findAll();
        products.sort(Comparator.comparing(Product::getPrice));
        return products;
    }

}

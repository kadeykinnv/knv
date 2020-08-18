package com.knv.restApiProject.rest;

import com.knv.restApiProject.model.Product;
import com.knv.restApiProject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @PostMapping("/createProduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
         productService.deleteProduct(id);
    }
    @PostMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {return productService.updateProduct(product); }
    @GetMapping("/sortProductName")
    public List<Product> sortByProductName() {
        return productService.sortByProductName();
    }
    @GetMapping("/sortProductPrice")
    public List<Product> sortByProductPrice() {
        return productService.sortByProductPrice();
    }
}


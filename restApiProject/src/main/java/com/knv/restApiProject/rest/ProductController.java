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

    @RequestMapping(path = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @RequestMapping(path = "/updateProduct", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/sortByProductName")
    public List<Product> sortByProductName() {
        return productService.sortByProductName();
    }

    @GetMapping("/sortByProductPrice")
    public List<Product> sortByProductPrice() {
        return productService.sortByProductPrice();
    }
}




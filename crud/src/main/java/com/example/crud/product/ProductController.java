package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    //DI
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProducts(); // di object
    }

    @PostMapping
    public ResponseEntity<Object> insertProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @DeleteMapping(path = "{productId}") //url recibida por url
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Long id) {
        return this.productService.deleteProduct(id);
    }
}

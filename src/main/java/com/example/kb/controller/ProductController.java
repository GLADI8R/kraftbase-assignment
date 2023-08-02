package com.example.kb.controller;

import com.example.kb.model.Product;
import com.example.kb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product add(@RequestBody Product p) {
        return productService.saveProduct(p);
    }

    @GetMapping("/prod")
    public List<Product> list() {
        return productService.getAllProducts();
    }
}

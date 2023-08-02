package com.example.kb.service;

import com.example.kb.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(Product p);
    List<Product> getAllProducts();

    Product updateProduct(Integer quanti, Integer id);
}

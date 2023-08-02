package com.example.kb.service;

import com.example.kb.model.Product;
import com.example.kb.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository p) {
        this.productRepository = p;
    }

    @Override
    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product updateProduct(Integer quanti, Integer id) {
        return productRepository.updateProd(quanti, id);
    }
}

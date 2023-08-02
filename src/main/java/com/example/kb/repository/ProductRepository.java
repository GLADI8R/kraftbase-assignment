package com.example.kb.repository;

import com.example.kb.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value="SELECT * FROM product", nativeQuery = true)
    List<Product> findAllProducts();

    @Query(value="UPDATE product SET quantity=:#{#q} WHERE prod_id=:#{#id}", nativeQuery = true)
    Product updateProd(@Param("q") Integer q, @Param("id") Integer id);
}

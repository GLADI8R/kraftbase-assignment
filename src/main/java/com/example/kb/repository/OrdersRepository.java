package com.example.kb.repository;

import com.example.kb.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "SELECT * FROM orders WHERE id=:#{#id}", nativeQuery = true)
    List<Orders> getOrdersByID(@Param("id") Integer id);

    @Query(value = "SELECT * FROM orders WHERE cust_id=:#{#id}", nativeQuery = true)
    List<Orders> getOrdersByCustomer(@Param("id") Integer id);
}

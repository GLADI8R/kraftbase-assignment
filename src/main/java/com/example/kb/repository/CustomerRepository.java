package com.example.kb.repository;

import com.example.kb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value="SELECT * FROM customer WHERE cust_id=:#{#id}", nativeQuery = true)
    List<Customer> findCustomerById(@Param("id") Integer id);
}

package com.example.kb.service;

import com.example.kb.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer saveCustomer(Customer c);

    List<Customer> getAllCustomers(Integer id);
}

package com.example.kb.service;

import com.example.kb.model.Customer;

import com.example.kb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public List<Customer> getAllCustomers(Integer id) {
        return customerRepository.findCustomerById(id);
    }
}

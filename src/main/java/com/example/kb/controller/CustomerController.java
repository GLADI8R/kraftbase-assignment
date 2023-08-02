package com.example.kb.controller;

import com.example.kb.model.Customer;
import com.example.kb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer c) {
        return customerService.saveCustomer(c);
    }

    @GetMapping("/getCustomer")
    public List<Customer> list(@RequestBody Integer id) {
        return customerService.getAllCustomers(id);
    }
}

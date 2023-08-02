package com.example.kb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer cust_id;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(Integer cust_id, String name, String email) {
        this.cust_id = cust_id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return cust_id;
    }

    public void setId(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

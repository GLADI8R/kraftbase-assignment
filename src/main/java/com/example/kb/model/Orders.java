package com.example.kb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer cust_id;
    private List<Integer> products;
    private List<Integer> quantity;
    private Float price;

    public Orders() {
    }

    public Orders(Integer id, Integer cust_id, String p, String q, Float price) {
        this.id = id;
        this.cust_id = cust_id;

        String[] tmp = p.split(",");
        for(String s:tmp) {
            this.products.add(Integer.parseInt(s.trim()));
        }

        String[] t = q.split(",");
        for(String s: t) {
            this.quantity.add(Integer.parseInt(s.trim()));
        }

        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

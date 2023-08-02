package com.example.kb.service;

import com.example.kb.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {

    Orders saveOrder(Orders o);

    List<Orders> getOrdersById(Integer id);

    List<Orders> getOrdersByCustomer(Integer id);
}

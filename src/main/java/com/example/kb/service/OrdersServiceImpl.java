package com.example.kb.service;

import com.example.kb.model.Orders;
import com.example.kb.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders saveOrder(Orders o) {
        return ordersRepository.save(o);
    }

    @Override
    public List<Orders> getOrdersById(Integer id){
        return ordersRepository.getOrdersByID(id);
    }

    @Override
    public List<Orders> getOrdersByCustomer(Integer id) {
        return ordersRepository.getOrdersByCustomer(id);
    }
}

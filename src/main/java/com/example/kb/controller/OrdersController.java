package com.example.kb.controller;

import com.example.kb.model.Orders;
import com.example.kb.model.Product;
import com.example.kb.service.OrdersService;
import com.example.kb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/api")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addOrder")
    public Orders addOrder(@RequestBody Orders o) {
        return ordersService.saveOrder(o);
    }

    @GetMapping("/getOrdersById")
    public List<Orders> getOrdersById(@RequestBody Integer id) {
        return ordersService.getOrdersById(id);
    }

    @GetMapping("/getOrdersByCustomer")
    public List<Orders> getOrdersByCustomer(@RequestBody Integer id) {
        return ordersService.getOrdersByCustomer(id);
    }

    // Order method to order stuffs
    @PostMapping("/order")
    public Orders order(@RequestBody Integer cust_id, @RequestBody Map<Integer, Integer> payload) {

        List<Product> products = productService.getAllProducts();
        List<Integer> pro = new ArrayList<Integer>();
        List<Integer> quant = new ArrayList<Integer>();
        Float total_price = 0.00F;
        for (Map.Entry<Integer, Integer> entry : payload.entrySet()) {

            for(Product p:products) {
                if(p.getId() == entry.getKey()) {
                    if(p.getQuantity() - entry.getValue() >= 0) {
                        p.setQuantity(p.getQuantity() - entry.getValue());
                        productService.updateProduct(p.getQuantity(), p.getId());
                        pro.add(entry.getKey());
                        quant.add(entry.getValue());
                        total_price += p.getPrice() * entry.getValue();
                    } else {
                        System.out.println("Not enough items in inventory!");
                        return new Orders();
                    }

                    break;
                }
            }

        }

        Integer id = new Random().nextInt(100000);
        Orders o = new Orders(id,
                cust_id,
                pro.stream().map(String::valueOf).collect(Collectors.joining(",")),
                quant.stream().map(String::valueOf).collect(Collectors.joining(",")),
                total_price);

        return ordersService.saveOrder(o);
    }
}

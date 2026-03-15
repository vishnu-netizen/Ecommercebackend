package com.example.ecommerce.controller;

import com.example.ecommerce.modal.DTO.OrderRequest;
import com.example.ecommerce.modal.DTO.OrderResponse;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderservice;
    @PostMapping("/orders/place")
    public String placeOrder(@RequestBody OrderRequest orderrequest){
        orderservice.placeOrder(orderrequest);
        return "DONEl";
    }
    @GetMapping("/orders")
    public List<OrderResponse> getallorders(){
        return orderservice.getAllOrderResponses();
    }
}

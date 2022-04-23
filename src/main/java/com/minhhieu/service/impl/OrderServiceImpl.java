/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.service.impl;

import com.minhhieu.pojos.Cart;
import com.minhhieu.repository.OrderRepository;
import com.minhhieu.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public boolean addReceipt(Map<Integer, Cart> cart) {
        if(cart != null)
            return this.orderRepository.addReceipt(cart);
        return false;
    }
    
}

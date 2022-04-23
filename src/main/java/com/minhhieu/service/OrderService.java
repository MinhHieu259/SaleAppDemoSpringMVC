/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minhhieu.service;

import com.minhhieu.pojos.Cart;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface OrderService {
    boolean addReceipt(Map<Integer, Cart> cart);
}

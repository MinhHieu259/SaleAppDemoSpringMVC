/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minhhieu.service;

import com.minhhieu.pojos.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ProductService {
    List<Product> getProducts(String kw, int page);
    Long countProduct();
    boolean addOrUpdate(Product product);
    Product getProductById(int id);
}

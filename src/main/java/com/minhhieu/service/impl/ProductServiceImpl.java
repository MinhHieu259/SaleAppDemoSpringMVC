/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.minhhieu.pojos.Product;
import com.minhhieu.repository.ProductRepository;
import com.minhhieu.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }

    @Override
    public boolean addOrUpdate(Product product) {
//         try {
//               Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
//                        ObjectUtils.asMap("resource_type", "auto"));
//               product.setImage((String) r.get("secure_url"));
//               return this.productRepository.addOrUpdate(product);
//            } catch (IOException ex) {
//                System.out.println("ADD PRODUCT " + ex.getMessage());
//           }
         return false;
    }

    @Override
    public Long countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

}

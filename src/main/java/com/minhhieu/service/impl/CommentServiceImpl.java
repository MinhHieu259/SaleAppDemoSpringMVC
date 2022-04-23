/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.service.impl;

import com.minhhieu.pojos.Comment;
import com.minhhieu.pojos.Product;
import com.minhhieu.pojos.User;
import com.minhhieu.repository.CommentRepository;
import com.minhhieu.repository.ProductRepository;
import com.minhhieu.repository.UserRepository;
import com.minhhieu.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private ProductRepository productRepository; 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public Comment addComment(String content, int productId, User creator) {
        Product p = this.productRepository.getProductById(productId);
//        User u = this.userRepository.getUserById(9);
        
        Comment c = new Comment();
        c.setContent(content);
        c.setProductId(p);
        c.setUserId(creator);
        c.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(c);
    }
    
}

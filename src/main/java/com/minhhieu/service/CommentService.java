/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minhhieu.service;

import com.minhhieu.pojos.Comment;
import com.minhhieu.pojos.User;

/**
 *
 * @author ASUS
 */
public interface CommentService {
    Comment addComment(String content, int productId, User creator);
}

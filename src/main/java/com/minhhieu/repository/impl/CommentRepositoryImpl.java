/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.repository.impl;

import com.minhhieu.pojos.Comment;
import com.minhhieu.repository.CommentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Comment addComment(Comment c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(c);
            
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}

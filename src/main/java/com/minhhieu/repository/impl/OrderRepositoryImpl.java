/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.repository.impl;

import com.minhhieu.pojos.Cart;
import com.minhhieu.pojos.OrderDetail;
import com.minhhieu.pojos.SaleOrder;
import com.minhhieu.repository.OrderRepository;
import com.minhhieu.repository.ProductRepository;
import com.minhhieu.repository.UserRepository;
import com.minhhieu.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            SaleOrder order = new SaleOrder();
            order.setUserId(this.userRepository.getUserById(9));
            order.setCreatedDate(new Date());

            Map<String, String> stats = Utils.cartStats(cart);
            order.setAmount(Long.parseLong(stats.get("amount")));
            session.save(order);

            for (Cart c : cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setOrderId(order);
                d.setProductId(this.productRepository.getProductById(c.getProductId()));
                d.setUnitPrice(c.getPrice());
                d.setNum(c.getQuantity());

                session.save(d);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}

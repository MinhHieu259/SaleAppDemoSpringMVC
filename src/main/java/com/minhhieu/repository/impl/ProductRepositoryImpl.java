/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhhieu.repository.impl;

import com.minhhieu.pojos.Comment;
import com.minhhieu.pojos.OrderDetail;
import com.minhhieu.pojos.Product;
import com.minhhieu.repository.ProductRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * n
 *
 * @author ASUS
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    public LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Product> getProducts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder buider = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = buider.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = buider.like(root.get("name").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }

        query = query.orderBy(buider.desc(root.get("id")));

        Query q = session.createQuery(query);
        int max = 9;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);
            return true;
        } catch (Exception e) {
            System.out.println("== ADD PRODUCT ERROR ==" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Product");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public List<Object[]> getHotProducts(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder buider = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = buider.createQuery(Object[].class);
        Root rootP = query.from(Product.class);
        Root rootD = query.from(OrderDetail.class);

        query = query.where(buider.equal(rootD.get("productId"), rootP.get("id")));
        query.multiselect(rootP.get("id"), rootP.get("name"), rootP.get("price"), rootP.get("image"),
                buider.count(rootP.get("id")));
        query = query.groupBy(rootP.get("id"));
        query = query.orderBy(buider.desc(buider.count(rootP.get("id"))));

        Query q = session.createQuery(query);
        q.setMaxResults(num);

        return q.getResultList();
    }

    @Override
    public List<Object[]> getMostDiscussProducts(int num) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder buider = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = buider.createQuery(Object[].class);
        Root rootP = query.from(Product.class);
        Root rootC = query.from(Comment.class);

        query = query.where(buider.equal(rootC.get("productId"), rootP.get("id")));
        query.multiselect(rootP.get("id"), rootP.get("name"), rootP.get("price"), rootP.get("image"),
                buider.count(rootP.get("id")));
        query = query.groupBy(rootP.get("id"));
        query = query.orderBy(buider.desc(buider.count(rootP.get("id"))),
               buider.desc(rootP.get("id")) );

        Query q = session.createQuery(query);
        q.setMaxResults(num);

        return q.getResultList();
    }

}

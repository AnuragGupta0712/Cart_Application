package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Item;
import com.cn.cnkart.entity.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class OrderDALImpl implements OrderDAL{
    @Autowired
    EntityManager entityManager;

    @Override
    public Order getOrderById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Order order = session.get(Order.class, id);
        return order;
    }

    @Override
    public void save(Order saveOrder) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(saveOrder);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Order order = session.get(Order.class, id);
        session.delete(order);
    }
}

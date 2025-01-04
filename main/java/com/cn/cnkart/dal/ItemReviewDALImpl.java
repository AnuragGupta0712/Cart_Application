package com.cn.cnkart.dal;

import com.cn.cnkart.entity.ItemReview;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ItemReviewDALImpl implements ItemReviewDAL{
    @Autowired
    EntityManager entityManager;
    @Override
    public void save(ItemReview itemReview) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(itemReview);
    }
}

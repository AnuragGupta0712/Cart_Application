package com.cn.cnkart.service;

import com.cn.cnkart.dal.ItemReviewDAL;
import com.cn.cnkart.entity.ItemReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ItemReviewService {
    @Autowired
    ItemReviewDAL itemReviewDAL;

    @Transactional
    public void save(ItemReview itemReview) {
        itemReviewDAL.save(itemReview);
    }
}

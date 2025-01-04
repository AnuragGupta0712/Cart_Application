package com.cn.cnkart.service;

import javax.transaction.Transactional;

import com.cn.cnkart.dal.ItemDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDetailsService {

    @Autowired
    ItemDetailsRepository itemDetailsRepository;

    public void delete(int id) {
        if(itemDetailsRepository.existsById(id)) {
            itemDetailsRepository.deleteById(id);
        }
    }
}

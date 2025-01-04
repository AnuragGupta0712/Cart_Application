package com.cn.cnkart.service;

import com.cn.cnkart.dal.ItemRepository;
import com.cn.cnkart.dal.OrderDAL;
import com.cn.cnkart.entity.Item;
import com.cn.cnkart.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAL orderDAL;
    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public Order getOrderById(int id) {
        return orderDAL.getOrderById(id);
    }

    @Transactional
    public void saveOrder(Order order) {
        Order saveOrder = new Order();
        saveOrder.setOrderType(order.getOrderType());
        List<Item> itemList = new ArrayList<>();
        for(Item item: order.getItems()) {
            Item currentItem = itemRepository.findById(item.getId()).get();
            itemList.add(currentItem);
        }
        saveOrder.setItems(itemList);
        orderDAL.save(saveOrder);
    }

    @Transactional
    public void delete(int id) {
        orderDAL.delete(id);
    }
}

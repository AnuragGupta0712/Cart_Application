package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Item;
import com.cn.cnkart.entity.Order;

public interface OrderDAL {
    Order getOrderById(int id);

    void delete(int id);

    void save(Order saveOrder);
}

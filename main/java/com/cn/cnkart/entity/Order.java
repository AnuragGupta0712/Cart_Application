package com.cn.cnkart.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    private String orderType;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "order_item",joinColumns = @JoinColumn(name = "order_id"),inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    public int getId() {
        return id;
    }

   

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

package org.Masri.SimpleRest.Services.Impl;

import org.Masri.SimpleRest.Enteties.Order;
import org.Masri.SimpleRest.Services.OrderManagementService;

import java.util.ArrayList;
import java.util.List;

public class DefaultOrderManagementService implements OrderManagementService {
   private static DefaultOrderManagementService Instance;

    List<Order> orders = new ArrayList<Order>();
    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orders.stream().filter((Order)->Order.getCustomerId()==userId).toList();
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }
    public static DefaultOrderManagementService getInstance() {
     if(Instance==null){
         Instance = new DefaultOrderManagementService();
     }
        return Instance;
    }
}

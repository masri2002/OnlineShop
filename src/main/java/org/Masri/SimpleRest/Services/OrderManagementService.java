package org.Masri.SimpleRest.Services;

import org.Masri.SimpleRest.Enteties.Order;

import java.util.*;

public interface OrderManagementService {
    void addOrder(Order order);

    List<Order> getOrdersByUserId(int userId);

    List<Order> getOrders();
}

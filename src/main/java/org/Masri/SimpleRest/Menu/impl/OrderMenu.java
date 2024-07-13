package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Enteties.Order;
import org.Masri.SimpleRest.Menu.Menu;
import org.Masri.SimpleRest.Services.Impl.DefaultOrderManagementService;

import java.util.List;

public class OrderMenu implements Menu {
   private ApplicationContext context;
   private DefaultOrderManagementService orderManagementService;
    {
        context=ApplicationContext.getInstance();
        orderManagementService=DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
            System.out.println(
                    "Please, log in or create new account to see list of your orders");
            new MainMenu().start();
            return;
        } else {
            PrintUserOrder(context.getLoggedInUser().getId());
        }
    }

     private void PrintUserOrder(int id){

        List<Order>orders =orderManagementService.getOrdersByUserId(id);
         if (orders==null || orders.isEmpty()){
             System.out.println(
                     "Unfortunately, you don't have any orders yet. "
                             + "Navigate back to main menu to place a new order");
         }else{
             orders.forEach(System.out::println);
         }
     }
    @Override
    public void printMenuHeader() {
        System.out.println("Welcome To Order Menu");
    }
}

package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Enteties.Order;
import org.Masri.SimpleRest.Enteties.impl.DefaultOrder;
import org.Masri.SimpleRest.Menu.Menu;
import org.Masri.SimpleRest.Services.Impl.DefaultOrderManagementService;
import org.Masri.SimpleRest.Services.OrderManagementService;

import java.util.Scanner;

public class CheckOutMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;
    {
        context=ApplicationContext.getInstance();
        orderManagementService=DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        while (true) {
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();

            if (!createOrder(userInput)) {
                continue;
            }
            context.getSessionCart().clear();
            break;
        }
        System.out.println("Thanks for using our System :) ");
    }
 private boolean createOrder(String crdetCard){
     Order order =new DefaultOrder();
        if(!order.isCreditCardNumberValid(crdetCard)){
            return false;
        }
        order.setCreditCardNumber(crdetCard);
        order.setProducts(context.getSessionCart().getProducts());
        order.setCustomerId(context.getLoggedInUser().getId());
        orderManagementService.addOrder(order);
        return true;

 }
    @Override
    public void printMenuHeader() {
        System.out.println("---- Check out ----");
        System.out.print("Enter your credit card number without spaces and press enter if you confirm purchase: ");
    }
}

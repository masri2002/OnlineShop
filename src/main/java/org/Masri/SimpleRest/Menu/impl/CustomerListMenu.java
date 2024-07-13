package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Enteties.User;
import org.Masri.SimpleRest.Menu.Menu;
import org.Masri.SimpleRest.Services.Impl.DefaultUserManagementService;
import org.Masri.SimpleRest.Services.UserManagementService;

import java.util.List;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
      printMenuHeader();
        List<User> users = userManagementService.getUsers();
        if(users.isEmpty()){
            System.out.println("Theres no users ");
        }else{
            users.forEach(System.out::println);
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("--- users ---");
    }
}

package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Enteties.User;
import org.Masri.SimpleRest.Enteties.impl.DefaultUser;
import org.Masri.SimpleRest.Menu.Menu;
import org.Masri.SimpleRest.Services.Impl.DefaultUserManagementService;
import org.Masri.SimpleRest.Services.UserManagementService;

import java.util.List;
import java.util.Scanner;

public class SignUpMenu implements Menu {

    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }
    @Override
    public void start() {

        List<User> users = userManagementService.getUsers();

        printMenuHeader();

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter Your First Name:");
        String fN = scanner.nextLine();
        System.out.println("enter Your Last Name:");
        String lN = scanner.nextLine();
        System.out.println("Enter Your Email");
        String email = scanner.nextLine();
        System.out.println("enter Your Password:");
        String p = scanner.nextLine();
      try {
          User user = new DefaultUser(fN, lN,email, p);
          if(!users.contains(user)) {
              System.out.println(userManagementService.registerUser(user));
          }else{
              System.out.println("User already exists");
          }
      }catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
      }
    }
    @Override
    public void printMenuHeader() {
        System.out.println("Welcome to Signup Menu");
    }
}

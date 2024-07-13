package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Enteties.User;
import org.Masri.SimpleRest.Menu.Menu;
import org.Masri.SimpleRest.Services.Impl.DefaultUserManagementService;
import org.Masri.SimpleRest.Services.UserManagementService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email address:");
        String email = scanner.nextLine();
        User user=userManagementService.getUserByEmail(email);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        if(user==null ){
            System.out.println("Wrong email");
        }else if(!user.getPassword().equals(password)){
            System.out.println("Wrong Password");
        }
        else{
            System.out.println("Welcome Glad to see you back "
                    +user.getFirstName() +" "+user.getLastName()+System.lineSeparator());
            context.setLoggedInUser(user);
            new MainMenu().start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("Welcome to Application Again");
    }
}

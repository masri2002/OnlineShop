package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Menu.Menu;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        context.getLoggedInUser().setPassword(userInput);
        System.out.println("Your password has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("--- CHANGE PASSWORD ---");
        System.out.print("Enter new password: ");
    }
}

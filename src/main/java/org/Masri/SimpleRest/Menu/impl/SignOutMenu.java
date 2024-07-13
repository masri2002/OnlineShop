package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Menu.Menu;

public class SignOutMenu implements Menu {
    private ApplicationContext context;
    {
        context=ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);

    }

    @Override
    public void printMenuHeader() {
        System.out.println("Thanks for using Our System");
    }
}

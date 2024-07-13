package org.Masri.SimpleRest;

import org.Masri.SimpleRest.Menu.impl.MainMenu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        MainMenu menu=new MainMenu();
        menu.start();
    }
}
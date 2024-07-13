package org.Masri.SimpleRest.Enteties.impl;

import org.Masri.SimpleRest.Enteties.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DefaultUser implements User {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final  String PASSWORD_REGEX="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
    private static int id=0;
    private static int count=0;
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Password;

    public DefaultUser(String firstname, String lastname, String email, String password)throws IllegalArgumentException{
        if(!Pattern.matches(EMAIL_REGEX, email)){
            throw new IllegalArgumentException("Invalid email address");
        }
        if(!Pattern.matches(PASSWORD_REGEX, password)){
            throw new IllegalArgumentException("Invalid password");
        }
        this.id=++count;
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        Password = password;
    }

    @Override
    public String getFirstName()  {
        return this.Firstname;
    }

    @Override
    public String getLastName() {
        return this.Lastname;
    }

    @Override
    public String getPassword() {
        return this.Password;
    }

    @Override
    public String getEmail() {
        return this.Email;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setPassword(String newPassword) throws IllegalArgumentException{
        if(!Pattern.matches(PASSWORD_REGEX, newPassword)){
            throw new IllegalArgumentException("Invalid password");
        }
        this.Password = newPassword;
    }

    @Override
    public void setEmail(String newEmail) throws IllegalArgumentException {
        if(!Pattern.matches(EMAIL_REGEX, newEmail)){
            throw new IllegalArgumentException("Invalid email address");
        }
        this.Email = newEmail;
    }

    @Override
    public String toString() {
        return "DefaultUser{" +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}

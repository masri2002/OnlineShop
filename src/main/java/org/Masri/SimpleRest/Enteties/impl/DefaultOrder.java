package org.Masri.SimpleRest.Enteties.impl;

import org.Masri.SimpleRest.Enteties.Order;
import org.Masri.SimpleRest.Enteties.Product;

import java.util.List;

public class DefaultOrder implements Order {
    private String CreditCardNumber;
    private List<Product> products;
    private int userId;

    public DefaultOrder() {
    }

    public DefaultOrder(String creditCardNumber, List<Product> products, int userId) {
        this.CreditCardNumber = creditCardNumber;
        this.products = products;
        this.userId = userId;
    }

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        return userInput.length() == 16;
    }

    @Override
    public void setCreditCardNumber(String userInput) {
       if(isCreditCardNumberValid(userInput)){
           this.CreditCardNumber = userInput;
       }else{
           throw new IllegalArgumentException("Invalid credit card number");
       }
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
      this.userId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "CreditCardNumber='" + CreditCardNumber + '\'' +
                ", products=" + products +
                ", userId=" + userId +
                '}';
    }
}

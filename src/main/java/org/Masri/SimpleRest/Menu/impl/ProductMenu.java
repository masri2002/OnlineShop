package org.Masri.SimpleRest.Menu.impl;

import org.Masri.SimpleRest.Config.ApplicationContext;
import org.Masri.SimpleRest.Enteties.Cart;
import org.Masri.SimpleRest.Enteties.Product;
import org.Masri.SimpleRest.Menu.Menu;
import org.Masri.SimpleRest.Services.Impl.DefaultProductManagementService;
import org.Masri.SimpleRest.Services.ProductManagementService;

import java.util.List;
import java.util.Scanner;

public class ProductMenu implements Menu {
    private ApplicationContext context;
    private DefaultProductManagementService  productManagementService;
    {
        context=ApplicationContext.getInstance();
        productManagementService=DefaultProductManagementService.getInstance();
    }
    private static final String CHECKOUT = "checkout";
    @Override
    public void start() {
     Menu menu =null;
     Scanner scanner = new Scanner(System.in);
      while (true){
          printProduct();
          printMenuHeader();
          String line = scanner.nextLine();
          if(context.getLoggedInUser()==null){
              menu=new MainMenu();
              System.out.println("You have to login first!");
              break;
          }
          if(line.equalsIgnoreCase("menu")){
              menu=new MainMenu();
              break;
          }
          if(line.equalsIgnoreCase(CHECKOUT)){
              Cart sessionCart=context.getSessionCart();
              if(sessionCart==null || sessionCart.isEmpty()){
                  System.out.println("your cart is empty!");
              }else{
                  menu=new CheckOutMenu();
                  break;
              }
          }else{
              Product product =getProduct(line);
              if(product==null){
                  System.out.println("Product not found!");
                  continue;
              }
                  addToCart(product);
          }

      }
        menu.start();
    }
     private void printProduct (){
        List<Product> products = productManagementService.getProducts();
        products.forEach(System.out::println);
     }
    @Override
    public void printMenuHeader() {
        System.out.println("Welcome to Product menu");
        System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");

    }
    private Product getProduct(String id){
        int idx=Integer.parseInt(id);
        return productManagementService.getProductById(idx);
    }
    private void addToCart(Product product){
        context.getSessionCart().addProduct(product);
        System.out.printf("Product %s has been added to your cart. "
                + "If you want to add a new product - enter the product id. "
                + "If you want to proceed with checkout - enter word "
                + "'checkout' to console %n", product.getProductName());
    }
}

package ru.gb.perov.IntroSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.gb.perov.IntroSpring");
        help();
        CartServiceEE cart = context.getBean(CartServiceEE.class);
        ProductRepositiry repo = context.getBean(ProductRepositiry.class);
        Scanner in = new Scanner(System.in);
        String request;
        while (true) {
            request = in.nextLine();
            if (request.equals("exit")) {
                break;
            } else if (request.equals("all")) {
                System.out.println(repo.findAllProducts());
            } else if (request.equals("allc")) {
                cart.showAllProductsInCart();
            } else if (request.equals("help")) {
                help();
            } else if (request.substring(request.length() - 1).equals("-") &&
                    Long.parseLong(request.substring(0, request.length() - 1)) > 0) {
                cart.removeProductFromCart(Long.parseLong(request.substring(0, request.length() - 1)));
                cart.showAllProductsInCart();
            } else if (request.substring(request.length() - 1).equals("+") &&
                    Long.parseLong(request.substring(0, request.length() - 1)) > 0) {
                cart.addProductToCart(Long.parseLong(request.substring(0, request.length() - 1)));
                cart.showAllProductsInCart();
            } else {
                System.out.println("invalid command");
                help();
            }
        }
        context.close();
    }

    public static void help() {
        System.out.println("List of Command:");
        System.out.println("all - list of eligible products");
        System.out.println("allс - list of products in the cart");
        System.out.println("X+ - add product with id X to the cart");
        System.out.println("X- - remove product with id X from the cart");
        System.out.println("exit - ending the work of the cart");
        System.out.println("help - list this help");
        System.out.println("Type your command:");
    }

}

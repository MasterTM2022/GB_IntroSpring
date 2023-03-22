package ru.gb.perov.IntroSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@Scope("prototype")
public class CartServiceEE {
    private ArrayList<Product> cartProducts;

    @PostConstruct
    public void init() {
        cartProducts = new ArrayList<>();
    }

    @Autowired
    private ProductService productService;

    public void addProductToCart(Long productId) {
        if (cartProducts.size() == 0) {
            System.out.println("Cart is created");
        }
        cartProducts.add(productService.getProductById(productId));
        System.out.println(productService.getTitleById(productId) + " was/were added to cart");
    }

    public void removeProductFromCart(Long productId) {
        cartProducts.remove(productService.getProductById(productId));
    }


    public void showAllProductsInCart() {
        if (cartProducts.size() == 0) {
            System.out.println("The cart is enmpty");
        } else {
            System.out.println("In the cart:");
            for (Product product : cartProducts) {
                System.out.println("ID:" + product.getId() + "; " + product.getTitle() + "; " + product.getPrice());
            }
        }
    }
}

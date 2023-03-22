package ru.gb.perov.IntroSpring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositiry {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "bread", 10.0),
                new Product(2L, "milk", 11.5),
                new Product(3L, "eggs", 12.0),
                new Product(4L, "cheese", 12.5),
                new Product(5L, "butter", 13.0),
                new Product(6L, "cottage cheese", 13.5),
                new Product(7L, "sunflower oil", 14.0),
                new Product(8L, "flour", 14.5),
                new Product(9L, "salt", 15.0),
                new Product(10L, "sugar", 15.5)
        ));
    }

    public Product findById(long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public List<Product> findAllProducts() {
        return products;
    }

}

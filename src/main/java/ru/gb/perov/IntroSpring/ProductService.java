package ru.gb.perov.IntroSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private ProductRepositiry productRepositiry;

    public String getTitleById(long id) {
        return productRepositiry.findById(id).getTitle();
    }

    public Product getProductById(long id) {
        return productRepositiry.findById(id);
    }


}

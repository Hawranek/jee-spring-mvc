package pl.coderslab.controller.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductDao {
    private List<Product> products;

    public ProductDao() {
        this.products= Arrays.asList(
                new Product("Kiwi",12.5,1),
                new Product("Apple",2.,2),
                new Product("Banana",15.5,3),
                new Product("Watermelon",22.5,4),
                new Product("Orange",1.79,5),
                new Product("Lemon",1.5,6)
        );
    }

    public List<Product> getProducts() {
        return products;
    }
}

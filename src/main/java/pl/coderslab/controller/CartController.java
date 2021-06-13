package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.controller.model.Cart;
import pl.coderslab.controller.model.CartItem;
import pl.coderslab.controller.model.Product;
import pl.coderslab.controller.model.ProductDao;

import java.util.List;
import java.util.Random;

@Controller
public class CartController {
    private Cart cart;
    private ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
//    public String addtocart(){
    public String addtocart(@RequestParam(defaultValue = "-1") int id, @RequestParam(defaultValue = "1") int quantity) {
//        Random rand = new Random();
        if (id >= 0 && id < productDao.getProducts().size()) {
            if (cart.getItems().size() != 0) {

                for (CartItem item : cart.getItems()) {
                    if (item.getProduct().equals(productDao.getProducts().get(id))) {
                        item.setQuantity(item.getQuantity() + quantity);
                        return "Added to cart";
                    }
                }
            }
            cart.addToCart(new CartItem(quantity, productDao.getProducts().get(id)));
            return "Added to cart";
        } else {
            return "No such product available";
        }
//        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));

    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart() {
        System.out.println(cart.getItems().size());
        String html = "";
//        for(CartItem ci : this.cart.getItems()){
        int totalQuantity = this.cart.getItems().size();
        int totalProducts = 0;
        double totalValue = 0.0;
        for (CartItem item : this.cart.getItems()) {
            totalProducts += item.getQuantity();
            totalValue += (item.getProduct().getPrice() * item.getQuantity());

        }
        html = String.format("W koszyku jest %s pozycji.\n" +
                "W koszyku jest %s produktów.\n" +
                "Wartość koszyka to: %s.\n", totalQuantity, totalProducts, totalValue);
//            html += String.format("<div>%s - %s</div>", ci.getProduct().getName(), ci.getQuantity());
//        }

        return html;
    }
}

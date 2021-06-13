package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.controller.model.Cart;
import pl.coderslab.controller.model.CartItem;
import pl.coderslab.controller.model.Product;

import java.util.Random;

@Controller
public class CartController {
    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart(){
        String html = "";
        for(CartItem ci : this.cart.getItems()){
            html += String.format("<div>%s - %s</div>", ci.getProduct().getName(), ci.getQuantity());
        }

        return html;
    }
}
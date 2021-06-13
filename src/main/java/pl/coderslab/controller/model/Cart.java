package pl.coderslab.controller.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addToCart(CartItem item){
        this.items.add(item);
    }

    public List<CartItem> getItems() {
        return items;
    }
}
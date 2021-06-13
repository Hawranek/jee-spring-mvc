package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;

@Controller
@RequestMapping("/example")
public class ExampleController {
    @GetMapping("/home")
    public String homeJsp(Model m) {
        String backgroundColor = "white";
        String fontColor = "black";
        final int currentHour = LocalTime.now().getHour();
        if (currentHour < 8 || currentHour > 20) {
            backgroundColor = "black";
            fontColor = "white";
        }

        m.addAttribute("backgroundColor", backgroundColor);
        m.addAttribute("fontColor", fontColor);

        return "home";
    }
}

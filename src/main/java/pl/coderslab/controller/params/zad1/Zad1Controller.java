package pl.coderslab.controller.params.zad1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class Zad1Controller {
    @RequestMapping(path = "/random/{max}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String random(@PathVariable int max) {
        final int result = new Random(System.currentTimeMillis()).nextInt(max) + 1;

        return String.format("Użytkownik podał wartość %s. Wylosowano liczę: %s.", max, result);
    }

    @RequestMapping(path = "/random/{min}/{max}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String randomMinMax(@PathVariable int min, @PathVariable int max) {
        final int result = new Random(System.currentTimeMillis()).nextInt(max - min + 1) + min;

        return String.format("Użytkownik podał wartości %s i %s. Wylosowano liczę: %s.", min, max, result);
    }
}

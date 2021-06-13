package pl.coderslab.controller.params.zad1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class Zad3Controller {
//    Utwórz akcję dostępną pod adresem /hello/<firstName>/<lastName> gdzie firstName oraz lastName będą pobranymi parametrami.
//    Wyświetl w przeglądarce dane w następujący sposób: Witaj <firstName> <lastName>.

    @RequestMapping(path = "/hello/{firstName}/{lastName}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String randomMinMax(@PathVariable String firstName, @PathVariable String lastName) {

        return String.format("Witaj %s %s", firstName, lastName);
    }
}

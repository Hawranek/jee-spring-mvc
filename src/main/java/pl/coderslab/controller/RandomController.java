package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    @RequestMapping(path="/showRandom", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showRandom(){
        Random rand=new Random();
        Integer result= rand.nextInt(100);
        return "<h3>Wylosowano liczbę: </h3>"+"<h1>"+result+"</h2>";
    }
}

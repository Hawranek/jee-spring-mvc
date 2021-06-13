package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {

        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/helloView")
    public String helloView() {

        return "helloView";
    }

}

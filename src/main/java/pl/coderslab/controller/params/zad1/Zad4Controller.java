package pl.coderslab.controller.params.zad1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/first")
public class Zad4Controller {
    @GetMapping(value = "/form", produces = "text/html; charset=UTF-8")
    public String goToForm() {
        return "/form.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String showData(@RequestParam String paramName, @RequestParam String paramDate) {
        String[] date = paramDate.split("-");
//        LocalDate dateResult = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
        LocalDate dateResult = LocalDate.parse(paramDate);          //działa tak samo jak ten wyżej
        return paramName + " " + dateResult;
    }
}

package pl.coderslab.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {
    @GetMapping("/multiply")
    public String multiply(@RequestParam(defaultValue = "10") int size, Model m){
        m.addAttribute("size",size);
        return "multiply";
    }
    @GetMapping("/paramMultiply/{rows}/{cols}")
    public String paramMultiply(@PathVariable int rows,@PathVariable int cols, Model m){
        m.addAttribute("rows",rows);
        m.addAttribute("cols",cols);
        return "multiply2";
    }
}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class FreeTimeController {
    @RequestMapping(path="/free", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String free(){
        DayOfWeek dzien=LocalDate.now().getDayOfWeek();
        LocalTime czas=LocalTime.now();
        if(dzien==DayOfWeek.SATURDAY||dzien==DayOfWeek.SUNDAY){
            return "Wolne";
        }else {
            if (czas.isAfter(LocalTime.of(9,0))&&czas.isBefore(LocalTime.of(17,0))){
                return "Pracuję, nie dzwoń";
            }else {
                return "Po pracy";
            }
        }
    }

}

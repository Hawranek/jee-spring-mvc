package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logger")
public class LoggerController {
    private static final Logger log = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/log")
    @ResponseBody
    public String homeJsp() {
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.debug("debug");
        return "Zobacz do loga w konsoli";
    }
}

package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class CookieController {
    @GetMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String setCookie(HttpServletResponse response,
                            @PathVariable String value1, @PathVariable String value2) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "Cookies set";
    }

    @GetMapping("/getcookies1")
    @ResponseBody
    public String getCookiesByWebUtils(HttpServletRequest request) {
        String result = "";
        List<Cookie> cookies = Arrays.asList(
                WebUtils.getCookie(request, "cookie1"),
                WebUtils.getCookie(request, "cookie2"));
        for (Cookie cookie : cookies) {
            result += String.format("<div>%s : %s</div>", cookie.getName(), cookie.getValue());
        }
        return result;
    }

    @GetMapping("/getcookies2")
    @ResponseBody
    public String getCookiesByAnnotation(
            @CookieValue("cookie1") String value1,
            @CookieValue("cookie2") String value2) {
        String result = "";

        result += String.format("<div>%s</div><div>%s</div>", value1, value2);

        return result;
    }

}

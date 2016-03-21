package za.co.yellowfire.threesixty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mark P Ashworth
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}

package za.co.yellowfire.threesixty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mark P Ashworth
 */
@Controller
public class KudosController {

    @RequestMapping("/kudos")
    public String home() {
        return "kudos";
    }
}

package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {

        return "index";
    }

    @GetMapping("/intro")
    public String intro() {

        return "intro";
    }

    @GetMapping("/chat")
    public String chat() {

        return "chat";
    }

}

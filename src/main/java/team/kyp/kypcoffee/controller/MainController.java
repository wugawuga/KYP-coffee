package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {

        return "index";
    }
    @GetMapping("/mail")
    public String map() {

        return "mail";
    }
    @GetMapping("/intro")
    public String intro() {

        return "intro";
    }
    @GetMapping("/mypage")
    public String mypage() {

        return "mypage";
    }
    @GetMapping("/mypageGoogle")
    public String mypageGoogle() {

        return "mypageGoogle";
    }
    @GetMapping("/mypageKakao")
    public String mypageKakao() {

        return "mypageKakao";
    }
}

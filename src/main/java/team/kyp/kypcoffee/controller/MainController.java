package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.kyp.kypcoffee.domain.AuthInfo;

import javax.servlet.http.HttpSession;

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

    @GetMapping("/businessStore")
    public String businessStore(Model model, HttpSession session) {
        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        if(ai==null){
            return "/accessFailBusiness";
        }
        else if(ai.getType()==1) { //사업자 아니면 이용 불가
            return "/accessFailBusiness";
        }

        return "business/productsBusiness";
    }

}

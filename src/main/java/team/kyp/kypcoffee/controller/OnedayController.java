package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.domain.*;
import team.kyp.kypcoffee.domain.User.Kakao;
import team.kyp.kypcoffee.service.OnedayClassService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OnedayController {

    private OnedayClassService onedayClassService;

    public OnedayController(OnedayClassService onedayClassService){
        this.onedayClassService = onedayClassService;
    }

    @GetMapping("class")
    public String onedayClassForm(Model model){
        List<OnedayClassNum> classList = onedayClassService.selectOpenClass();

        model.addAttribute("classList", classList);
        return "onedayClass/onedayClass";
    }

    @GetMapping("class/regist/{classNum}")
    public String onedayClassRegistForm(OnedayClassRegiCommand onedayClassRegiCommand,
                                        @PathVariable("classNum") int classNum, HttpSession session, Model model){

        return "onedayClass/onedayClassRegi";
    }

    @PostMapping("class/regist")
    public String onedayClassRegist(OnedayClassRegiCommand onedayClassRegiCommand){
        return "redirect:/class";
    }

}

package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.domain.OnedayClassOpenCommand;
import team.kyp.kypcoffee.service.AdminOnedayClassService;

@Controller
public class OnedayClassController {

    private AdminOnedayClassService adminOnedayClassService;

    public OnedayClassController(AdminOnedayClassService adminOnedayClassService){
        this.adminOnedayClassService = adminOnedayClassService;
    }

    @GetMapping("adminOnedayClass")
    public String adminOnedayClassForm(OnedayClassOpenCommand onedayClassOpenCommand, Model model){
        return "admin/onedayClass/adminOnedayClass";
    }

    @PostMapping("adminOnedayClassOpen")
    public String onedayClassRegi(OnedayClassOpenCommand onedayClassOpenCommand) {
        //원데이클래스 오픈
        adminOnedayClassService.onedayClassOpen(onedayClassOpenCommand);
        return "admin/onedayClass/adminOnedayClass";
    }
}

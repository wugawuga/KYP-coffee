package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesStatusController {
    @GetMapping("saleStatus")
    public String salesStatus(){
        return "admin/salesStatus/salesStatus";
    }
}

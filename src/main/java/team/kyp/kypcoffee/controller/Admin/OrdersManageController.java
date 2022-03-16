package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersManageController {

    @GetMapping("ordersManage")
    public String ordersList(){

        return "admin/ordersManage/ordersManage";
    }
}

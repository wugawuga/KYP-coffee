package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.domain.AdminProductRegiCommand;
import team.kyp.kypcoffee.service.AdminProductRegiService;

import java.io.File;
import java.util.UUID;

@Controller
public class AdminProductController {

    private AdminProductRegiService adminProductRegiService;

    public AdminProductController(AdminProductRegiService adminProductRegiService) {
        this.adminProductRegiService = adminProductRegiService;
    }

    @GetMapping("adminProductRegi")
    public String productRegiForm(AdminProductRegiCommand adminProductRegiCommand){

        return "admin/product/productRegi";
    }

    @PostMapping("adminProductRegi")
    public String productRegi(AdminProductRegiCommand adminProductRegiCommand){

        //파일 업로드
        adminProductRegiService.uploadProductImg(adminProductRegiCommand);

        //DB에 정보저장
        adminProductRegiService.adminProductRegi(adminProductRegiCommand);

        return "redirect:/admin";
    }


}

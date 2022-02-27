package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.domain.AdminProductRegiCommand;
import team.kyp.kypcoffee.service.AdminProductRegiService;

import java.io.File;

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
        System.out.println("adminProductRegiCommand.getProductName() = " + adminProductRegiCommand.getProductName());
        System.out.println("adminProductRegiCommand.getProductQuantity() = " + adminProductRegiCommand.getProductQuantity());
        System.out.println("adminProductRegiCommand.getProductPrice() = " + adminProductRegiCommand.getProductPrice());
        System.out.println("adminProductRegiCommand.getProductImg() = " + adminProductRegiCommand.getProductImg());
        System.out.println("adminProductRegiCommand.getProductImg().getOriginalFilename() = " + adminProductRegiCommand.getProductImg().getOriginalFilename());

        String fileName = adminProductRegiCommand.getProductImg().getOriginalFilename();

        Boolean result = Boolean.FALSE;
        try{
            File folder = new File("C:\\productImg");
            if (!folder.exists()) folder.mkdirs();

            File destination = new File("C:\\productImg" + File.separator + fileName);
            adminProductRegiCommand.getProductImg().transferTo(destination);

            result = Boolean.TRUE;
        }catch (Exception e){
            e.printStackTrace();
        }

        return "admin/product/productRegi";
    }


}

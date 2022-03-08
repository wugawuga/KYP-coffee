package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.kyp.kypcoffee.domain.AdminProductRegiCommand;
import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.admin.ProductManage;
import team.kyp.kypcoffee.service.AdminProductRegiService;
import team.kyp.kypcoffee.service.admin.ProductManageService;

import java.util.List;

@Controller
public class ProductManageController {

    private ProductManageService productManageService;
    private AdminProductRegiService adminProductRegiService;

    public ProductManageController(ProductManageService productManageService, AdminProductRegiService adminProductRegiService) {
        this.productManageService = productManageService;
        this.adminProductRegiService = adminProductRegiService;
    }

    @GetMapping("productManage")
    public String productManageList(@RequestParam(value = "section", defaultValue="1") int section,
                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model){

        int totalCnt = productManageService.selectAllCnt();
        List<ProductManage> productList = productManageService.selectProductList(new Paging(section, pageNum));
        String totalCntJudge = productManageService.totalCntJudge(totalCnt);

        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("productList", productList);
        return "admin/product/productManageList";
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

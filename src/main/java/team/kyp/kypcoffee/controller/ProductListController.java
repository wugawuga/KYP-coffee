package team.kyp.kypcoffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.Product_info;
import team.kyp.kypcoffee.service.ProductListService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductListController {

    @Autowired
    ProductListService productListService;

    @GetMapping("/product")
    public String productList(Model model) {

        List<Product_info> all = productListService.findAll();

        model.addAttribute("all", all);

        return "product/products";
    }

    @GetMapping("/product/{productType}")
    @ResponseBody
    public List<Product_info> productType(@PathVariable("productType") int productType, Model model) {

        List<Product_info> type = productListService.findType(productType);

        return type;
    }

    @GetMapping("/products/details")
    public String productDetail(@RequestParam(value = "pdtCode", required = false) Long productCode, HttpSession session, Model model) {

        if (productCode == null) {

            return "redirect:/product";
        }

        Product_info info = productListService.detailByCode(productCode);

        model.addAttribute("info", info);

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        model.addAttribute("authInfo", ai);

        return "product/productsDetails";
    }
}

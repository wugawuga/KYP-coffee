package team.kyp.kypcoffee.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.Cart;
import team.kyp.kypcoffee.domain.CartCommand;
import team.kyp.kypcoffee.domain.OrderCommand;
import team.kyp.kypcoffee.service.CartService;
import team.kyp.kypcoffee.service.CartServiceImpl;
import team.kyp.kypcoffee.service.ProductListService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/cartAdd")
    public String cartAdd(CartCommand cartCommand) {

        cartService.createCart(cartCommand);

        return "redirect:/product";
    }

    @GetMapping("/cartList")
    public String cartList(HttpSession session, OrderCommand orderCommand, Model model) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        if(ai == null) {
            return "product/cartList";
        }else {
            List<Cart> cartList = cartService.findAll(ai.getNo());

            model.addAttribute("list", cartList);

            return "product/cartList";
        }
    }

    @DeleteMapping ("/cartList/del/{cartNum}")
    @ResponseBody
    public String delCart(@PathVariable("cartNum") int cartNum) {

        System.out.println("cartNum = " + cartNum);

        cartService.delCart(cartNum);

        return "";
    }
}

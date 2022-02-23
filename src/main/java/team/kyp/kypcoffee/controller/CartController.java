package team.kyp.kypcoffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.domain.CartCommand;
import team.kyp.kypcoffee.service.CartService;
import team.kyp.kypcoffee.service.ProductListService;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/cartAdd")
    public String cartAdd(CartCommand cartCommand) {

        System.out.println("카트 커맨드 : "+ cartCommand.getCartQuantity());

        cartService.createCart(cartCommand);

        return "redirect:/product";
    }
}

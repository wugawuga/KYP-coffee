package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.OrderCommand;
import team.kyp.kypcoffee.domain.Product_info;
import team.kyp.kypcoffee.service.OrderInfoService;
import team.kyp.kypcoffee.service.OrderInfoServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderInfoServiceImpl orderInfoServiceImpl;

    @PostMapping("/orderList")
    public String order(HttpSession session, OrderCommand orderCommand, Model model) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        int memberNum = ai.getNo();

        Member member = orderInfoServiceImpl.memberInfoByMemberNum(memberNum); // 멤버 정보 - 문제없음

        ArrayList<Integer> cartNum = orderCommand.getCartNum(); // 문제없음

        List<Product_info> pInfos = orderInfoServiceImpl.productInfo(cartNum);

        int totalPrice = 0;

        for (Product_info pInfo : pInfos) {
            totalPrice += pInfo.getProductPrice() * pInfo.getCartQuantity();
        }

        model.addAttribute("member", member);
        model.addAttribute("pInfos", pInfos);
        model.addAttribute("totalPrice", totalPrice);

        return "orders/order";
    }
}

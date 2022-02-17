package team.kyp.kypcoffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("memberList")
    public String memberList(Model model) {

        List<Member> list = service.selectAllMember();

        model.addAttribute("memberList", list);

        return "memberList";
    }
}

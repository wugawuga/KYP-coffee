package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import team.kyp.kypcoffee.domain.*;
import team.kyp.kypcoffee.service.IamportService;
import team.kyp.kypcoffee.service.QnaBoardService;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MypageController {

    private final QnaBoardService qnaBoardService;
    private final IamportService iamportService;

    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String mypageQna(@ModelAttribute("QnaBoard") QnaBoard qnaBoard, Model model, Errors errors, HttpSession session) {
        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        if(ai.getId().equals("admin")){
            return "admin/adminMain";
        }

        int memberNum = ai.getNo();

        List<QnaBoard> list = qnaBoardService.selectViewByNum(memberNum);
        model.addAttribute("boardList", list);

        List<Payment> payments = iamportService.selectPayment(memberNum);
        model.addAttribute("payment", payments);

        return "mypage";
    }

    @GetMapping("/mypage/{qnaBoardNum}")
    public String mypageView(@PathVariable("qnaBoardNum") int qnaBoardNum,
                             @ModelAttribute("QnaBoard") QnaBoard qnaBoard, Model model, HttpSession session) {

        QnaBoard view = qnaBoardService.selectView(qnaBoardNum);
        model.addAttribute("view", view);

        List<Comment> cmt = qnaBoardService.cmtList(qnaBoardNum);
        model.addAttribute("cmt", cmt);
        return "mypageView";
    }
}

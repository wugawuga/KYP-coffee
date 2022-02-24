package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.kyp.kypcoffee.domain.QnaBoard;
import team.kyp.kypcoffee.service.QnaBoardService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class QnaBoardController {

    private final QnaBoardService qnaBoardService;


    @GetMapping("/qnaBoard")
    public String qnaBoardList(Model model,HttpServletRequest request,QnaBoard qnaBoard) {

		List<QnaBoard> list = qnaBoardService.selectAllList();
		model.addAttribute("boardList",list);

        return "qnaBoard/list";
    }

}

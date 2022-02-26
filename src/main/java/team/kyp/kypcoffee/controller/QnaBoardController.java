package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.QnaBoard;
import team.kyp.kypcoffee.domain.QnaBoardWrite;
import team.kyp.kypcoffee.service.QnaBoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class QnaBoardController {

    private final QnaBoardService qnaBoardService;

    @GetMapping("/qnaBoard")
    public String qnaBoardList(@ModelAttribute ("QnaBoard") QnaBoard qnaBoard, Model model, Errors errors) {

		if(errors.hasErrors()) {
			return "/";
		}

		List<QnaBoard> list = qnaBoardService.selectAllList();
		model.addAttribute("boardList",list);

        return "qnaBoard/list";
    }

    @GetMapping("/qnaBoard/view/{qnaBoardNum}")
    public String qnaBoardView(@PathVariable("qnaBoardNum") int qnaBoardNum,
                               @ModelAttribute ("QnaBoard") QnaBoard qnaBoard, Model model) {

        QnaBoard view = qnaBoardService.selectView(qnaBoardNum);
        model.addAttribute("view", view);

        return "qnaBoard/view";
    }

    @GetMapping("/qnaBoard/write")
    public String qnaBoardWriteForm(Model model,HttpServletRequest request) {
        model.addAttribute("formWrite",new QnaBoardWrite());
        return "qnaBoard/write";
    }

    @RequestMapping(value="/qnaBoard/write", method= RequestMethod.POST) //글쓰기
    public String qnaBoardWrite(QnaBoardWrite qnaBoardWrite, Model model, HttpSession session) {

        AuthInfo ai = (AuthInfo)session.getAttribute("authInfo");
        qnaBoardWrite.setMno(ai.getNo());

        model.addAttribute("formWrite");
        qnaBoardService.boardWrite(qnaBoardWrite);

        List<QnaBoard> list = qnaBoardService.selectAllList();
        model.addAttribute("boardList",list);


        return "qnaBoard/list";
    }

    @GetMapping(value="/qnaBoard/edit/{qnaBoardNum}")
    public String qnaBoardEdit(@PathVariable("qnaBoardNum") int qnaBoardNum,Model model) {

        model.addAttribute("formEdit",new QnaBoardWrite());

        QnaBoard view = qnaBoardService.selectView(qnaBoardNum);
        model.addAttribute("view", view);

        return "qnaBoard/edit"; //폼으로 연결
    }


    @PostMapping(value="/qnaBoard/edit")
    public String qnaBoardEditForm(@ModelAttribute QnaBoardWrite qnaBoardWrite, Model model){

        qnaBoardService.boardEdit(qnaBoardWrite);


        //수정완료후 돌아갈화면에 보여줄정보
        List<QnaBoard> list = qnaBoardService.selectAllList();
        model.addAttribute("boardList",list);

        return "qnaBoard/list";
    }





    @RequestMapping(value="/qnaBoard/delete/{qnaBoardNum}") //게시글 삭제
    public String delete(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model,HttpServletRequest request) {

        qnaBoardService.boardDelete(qnaBoardNum);

        List<QnaBoard> list = qnaBoardService.selectAllList();
        model.addAttribute("boardList",list);


        return "qnaBoard/list";
    }
}

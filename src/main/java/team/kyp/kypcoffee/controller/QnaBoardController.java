package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.domain.*;
import team.kyp.kypcoffee.domain.User.Kakao;
import team.kyp.kypcoffee.service.MemberRegisterService;
import team.kyp.kypcoffee.service.QnaBoardService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class QnaBoardController {

    private final QnaBoardService qnaBoardService;
    private final MemberRegisterService memberRegisterService;

    @GetMapping("/qnaBoard")
    public String qnaBoardList(@ModelAttribute("QnaBoard") QnaBoard qnaBoard, Model model, Errors errors,
                               @RequestParam(value = "section", defaultValue = "1") int section,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {

        if (errors.hasErrors()) {
            return "/";
        }

        int totalCnt = qnaBoardService.pagingCount();
        Paging paging = new Paging(section, pageNum);

        List<QnaBoard> list = qnaBoardService.selectBoardPaging(paging);
        String totalCntJudge = qnaBoardService.totalCntJudge(totalCnt);

        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardList", list);

        return "qnaBoard/list";
    }

    @GetMapping("/qnaBoard/view/{qnaBoardNum}") //회원만 접근 가능
    public String qnaBoardView(@PathVariable("qnaBoardNum") int qnaBoardNum,
                               @ModelAttribute("QnaBoard") QnaBoard qnaBoard, Model model, HttpSession session) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");


        if (ai == null) { //로그인 안했으면 게시글 읽기 불가
            return "/accessFail";
        }

        QnaBoard view = qnaBoardService.selectView(qnaBoardNum);
        model.addAttribute("view", view);

        List<Comment> cmt = qnaBoardService.cmtList(qnaBoardNum);
        model.addAttribute("cmt", cmt);


        return "qnaBoard/view";
    }

    @GetMapping("/qnaBoard/write")
    public String qnaBoardWriteForm(Model model, HttpServletRequest request, HttpSession session) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        if (ai == null) { //로그인 안했으면 게시글 쓰기 불가
            return "/accessFail";
        }

        model.addAttribute("formWrite", new QnaBoardWrite());
        return "qnaBoard/write";
    }

    @RequestMapping(value = "/qnaBoard/write", method = RequestMethod.POST) //글쓰기
    public String qnaBoardWrite(QnaBoardWrite qnaBoardWrite, Model model, HttpSession session,
                                @RequestParam(value = "section", defaultValue = "1") int section,
                                @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        qnaBoardWrite.setMno(ai.getNo());
        model.addAttribute("formWrite");
        qnaBoardService.boardWrite(qnaBoardWrite);

        int totalCnt = qnaBoardService.pagingCount();
        Paging paging = new Paging(section, pageNum);

        List<QnaBoard> list = qnaBoardService.selectBoardPaging(paging);
        String totalCntJudge = qnaBoardService.totalCntJudge(totalCnt);

        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardList", list);

        return "qnaBoard/list";
    }



    @GetMapping(value="/qnaBoard/edit/{qnaBoardNum}") //수정 버튼 누르면 글쓴이와 대조
    public String qnaBoardEdit(@PathVariable("qnaBoardNum") int qnaBoardNum,Model model,HttpSession session,
                               HttpServletResponse response) throws IOException {

        model.addAttribute("formEdit", new QnaBoardWrite());

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        QnaBoard view = qnaBoardService.selectView(qnaBoardNum);

        if (ai.getNo() == view.getMemberNum()) {
            model.addAttribute("view", view);
            return "qnaBoard/edit";

        } else if (ai.getNo() != view.getMemberNum()) {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('작성자 본인만 게시글을 수정할 수 있습니다. 게시판 리스트로 돌아갑니다.'); </script>");
            out.println("<script>location.href='/qnaBoard' </script>");
            out.flush();

        }
        return "qnaBoard/list";
    }


    @PostMapping(value="/qnaBoard/edit")
    public String qnaBoardEditForm(@ModelAttribute QnaBoardWrite qnaBoardWrite, Model model){

        qnaBoardService.boardEdit(qnaBoardWrite);

        return "redirect:/qnaBoard/view/" + qnaBoardWrite.getBno();
    }


    @RequestMapping(value="/qnaBoard/delete/{qnaBoardNum}") //게시글 삭제
    public String delete(@PathVariable("qnaBoardNum") int qnaBoardNum, Model model,
        @RequestParam(value = "section", defaultValue="1") int section,
        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         HttpSession session, HttpServletResponse response) throws IOException {

        AuthInfo ai = (AuthInfo)session.getAttribute("authInfo");

        QnaBoard view = qnaBoardService.selectView(qnaBoardNum);

            if (ai.getNo() == view.getMemberNum()) {
                qnaBoardService.boardDelete(qnaBoardNum);

                int totalCnt = qnaBoardService.pagingCount();
                Paging paging = new Paging(section,pageNum);

                List<QnaBoard> list = qnaBoardService.selectBoardPaging(paging);
                String totalCntJudge = qnaBoardService.totalCntJudge(totalCnt);

                model.addAttribute("totalCntJudge", totalCntJudge);
                model.addAttribute("totalCnt", totalCnt);
                model.addAttribute("section", section);
                model.addAttribute("pageNum", pageNum);
                model.addAttribute("boardList", list);

                return "qnaBoard/list";

            }else if(ai.getNo() != view.getMemberNum()){
                response.setContentType("text/html; charset=euc-kr");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('작성자 본인만 게시글을 삭제할 수 있습니다. 게시판 리스트로 돌아갑니다.'); </script>");
                out.println("<script>location.href='/qnaBoard'</script>");
                out.flush();

        }

        int totalCnt = qnaBoardService.pagingCount();
        Paging paging = new Paging(section,pageNum);

        List<QnaBoard> list = qnaBoardService.selectBoardPaging(paging);
        String totalCntJudge = qnaBoardService.totalCntJudge(totalCnt);

        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardList", list);
        return "qnaBoard/list";
    }

    ////////////////////////////////////////////////////////////////////////////////////코멘트

    @GetMapping("/qnaBoard/cmtWrite/{qnaBoardNum}") //답변은 관리자만 작성 가능
    public String cmtWriteForm(@PathVariable("qnaBoardNum") int qnaBoardNum,Model model, HttpSession session){

            QnaBoard view = qnaBoardService.selectView(qnaBoardNum);
            model.addAttribute("view", view);
            model.addAttribute("cmtWrite",new QnaBoardWrite());

            return "qnaBoard/cmtWrite";
        }

    @RequestMapping(value="/qnaBoard/cmtWrite/cmtWrite", method= RequestMethod.POST) //답변쓰기
    public String cmtWrite(CommentWrite cmtWrite, Model model, HttpSession session) {

        qnaBoardService.cmtWrite(cmtWrite);

        List<QnaBoard> list = qnaBoardService.selectAllList();
        model.addAttribute("boardList",list);

        return "redirect:/qnaBoard/view/" + cmtWrite.getBno();
    }

    @RequestMapping(value="/qnaBoard/cmtDelete/{cmtNum}")
    public String cmtDelete(@PathVariable("cmtNum") int cmtNum, Model model,
                            @RequestParam(value = "section", defaultValue="1") int section,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {

        qnaBoardService.cmtDelete(cmtNum);

        int totalCnt = qnaBoardService.pagingCount();
        Paging paging = new Paging(section,pageNum);

        List<QnaBoard> list = qnaBoardService.selectBoardPaging(paging);
        String totalCntJudge = qnaBoardService.totalCntJudge(totalCnt);

        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("boardList", list);

        return "qnaBoard/list";
    }
}

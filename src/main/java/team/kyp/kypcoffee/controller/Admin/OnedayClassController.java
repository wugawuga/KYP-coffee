package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.kyp.kypcoffee.domain.*;
import team.kyp.kypcoffee.service.AdminOnedayClassService;

import java.util.List;

@Controller
public class OnedayClassController {

    private AdminOnedayClassService adminOnedayClassService;

    public OnedayClassController(AdminOnedayClassService adminOnedayClassService){
        this.adminOnedayClassService = adminOnedayClassService;
    }

    @GetMapping("adminOnedayClass")
    public String adminOnedayClassForm(OnedayClassOpenCommand onedayClassOpenCommand,
                                       @RequestParam(value = "section", defaultValue="1") int section,
                                       @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model){

        int totalCnt = adminOnedayClassService.selectAllNumber();
        List<OnedayClass> list = adminOnedayClassService.selectPaging(new Paging(section, pageNum));
        String totalCntJudge = adminOnedayClassService.totalCntJudge(totalCnt);

        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("onedaylist", list);

        return "admin/onedayClass/adminOnedayClass";
    }

    @PostMapping("adminOnedayClassOpen")
    public String onedayClassRegi(OnedayClassOpenCommand onedayClassOpenCommand) {
        //원데이클래스 오픈
        adminOnedayClassService.onedayClassOpen(onedayClassOpenCommand);
        return "redirect:/adminOnedayClass";
    }

    @GetMapping("adminOnedayClass/Detail/{classNum}")
    public String onedayClassDetail(@PathVariable("classNum") int classNum, Model model){
        //원데이클래스 신청자 정보
        List<OnedayClassApplierInfo> infoList = adminOnedayClassService.selectClassByNum(classNum);

        model.addAttribute("infoList", infoList);
        return "admin/onedayClass/adminOnedayClassDetail";
    }

    @GetMapping("adminOnedayClass/delete/{classNum}")
    public String deleteClass(@PathVariable("classNum") int classNum){

        adminOnedayClassService.deleteClass(classNum);
        return "redirect:/adminOnedayClass";
    }

    @GetMapping("adminOnedayClass/applierDelete/{classNum}/{memberNum}")
    public String onedayClassApplierDelete(@PathVariable("classNum") int classNum, @PathVariable("memberNum") int memberNum){
        //관리자가 신청자 취소 시키기
        adminOnedayClassService.deleteApplierByNum(new OnedayDelete(classNum, memberNum));
        return "redirect:/adminOnedayClass/Detail/"+classNum;
    }
}

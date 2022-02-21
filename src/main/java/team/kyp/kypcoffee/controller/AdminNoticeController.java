package team.kyp.kypcoffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.kyp.kypcoffee.domain.Notice;
import team.kyp.kypcoffee.service.NoticeServiceImpl;

import java.util.List;


@Controller
public class AdminNoticeController {

    @Autowired
    private NoticeServiceImpl noticeService;

    @GetMapping("adminNotice")
    public String adminNotice(Model model) {

        List<Notice> list = noticeService.selectAllNotice();

        model.addAttribute("noticeList", list);

        return "admin/noticeList";
    }
}

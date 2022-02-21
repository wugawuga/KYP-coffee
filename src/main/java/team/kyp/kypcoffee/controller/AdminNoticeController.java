package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminNoticeController {

    @GetMapping("adminNotice")
    public String adminNotice() {

        return "admin/noticeList";
    }
}

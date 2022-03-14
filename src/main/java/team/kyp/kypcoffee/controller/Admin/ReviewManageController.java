package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.admin.InventoryManage;
import team.kyp.kypcoffee.domain.admin.Review;
import team.kyp.kypcoffee.service.CrawlingService;
import team.kyp.kypcoffee.service.admin.ReviewService;

import java.util.List;

@Controller
public class ReviewManageController {

    private CrawlingService crawlingService;
    private ReviewService reviewService;

    public ReviewManageController(CrawlingService crawlingService, ReviewService reviewService){
        this.crawlingService = crawlingService;
        this.reviewService = reviewService;
    }

    @GetMapping("reviewManage")
    public String reviewManageList(@RequestParam(value = "section", defaultValue="1") int section,
                                   @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, Model model){

        int totalCnt = reviewService.selectAllCnt();
        List<Review> reviewList = reviewService.selectReviewList(new Paging(section, pageNum));
        String totalCntJudge = reviewService.totalCntJudge(totalCnt);

        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("totalCntJudge", totalCntJudge);
        model.addAttribute("section", section);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("reviewList", reviewList);

        return "admin/review/reviewManage";
    }

    @GetMapping("reviewManage/regist")
    public String reviewRegi(){

        crawlingService.instaKypCoffee();

        return "redirect:/reviewManage";
    }
}

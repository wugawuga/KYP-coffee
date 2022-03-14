package team.kyp.kypcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import team.kyp.kypcoffee.service.CrawlingService;

@Controller
public class ReviewController {

    private CrawlingService crawlingService;

    public ReviewController(CrawlingService crawlingService){
        this.crawlingService = crawlingService;
    }

    @GetMapping("review")
    public String reviewList(){

        crawlingService.instaKypCoffee();

        return "review/reviewList";
    }
}

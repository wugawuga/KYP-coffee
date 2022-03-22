package team.kyp.kypcoffee.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.kyp.kypcoffee.domain.admin.SummarySales;
import team.kyp.kypcoffee.service.admin.SalesStatusService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SalesStatusController {

    private SalesStatusService salesStatusService;

    public SalesStatusController(SalesStatusService salesStatusService){
        this.salesStatusService = salesStatusService;
    }

    @GetMapping("salesStatus")
    public String salesStatusDay(@RequestParam(value = "payDate", defaultValue="1") String payDate, Model model){

        if(payDate.equals("1")){
            payDate =  LocalDate.now().toString();
        }

        List<SummarySales> salesList = salesStatusService.selectSummarySales(payDate);

        model.addAttribute("salesList", salesList);
        model.addAttribute("payDate", payDate);

        return "admin/salesStatus/salesStatusDay";
    }

    @GetMapping("salesStatus/month")
    public String salesStatusMonth(@RequestParam(value = "payDate", defaultValue="1") String payDate, Model model){

        if(payDate.equals("1")){
            payDate =  LocalDate.now().toString().substring(0,7);
        }

        List<SummarySales> salesList = salesStatusService.selectSummarySalesMonth(payDate);

        model.addAttribute("salesList", salesList);
        model.addAttribute("payDate", payDate);

        return "admin/salesStatus/salesStatusMonth";
    }
}

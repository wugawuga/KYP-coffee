package team.kyp.kypcoffee.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.service.IamportService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class PayCheckController {

    private IamportService iamportService;

    @Autowired
    public PayCheckController(IamportService iamportService) {
        this.iamportService = iamportService;
    }

    private IamportClient api;

    public PayCheckController() {
        this.api = new IamportClient("3208902506195454", "5f2aeafc2377d15f2bafad578b698cc21f3255a6188f3b7e3dce66a5efd8151002e88e4115c515eb");
    }

    @ResponseBody
    @PostMapping(value = "/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(Model model, Locale locale, HttpSession session
            , @PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {

        return api.paymentByImpUid(imp_uid);
    }

    @PostMapping(value = "/verifyPayCheck")
    public void payCheck(@RequestParam("imp_uid") String imp_uid) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject body = new JSONObject();
        body.put("imp_key", "3208902506195454");
        body.put("imp_secret", "5f2aeafc2377d15f2bafad578b698cc21f3255a6188f3b7e3dce66a5efd8151002e88e4115c515eb");

        try {
            HttpEntity<JSONObject> entity = new HttpEntity<>(body, headers);
            ResponseEntity<JSONObject> token = restTemplate.postForEntity("https://api.iamport.kr/users/getToken", entity, JSONObject.class);

            System.out.println("token = " + token);
            System.out.println("token.getStatusCode() = " + token.getStatusCode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @PostMapping(value = "/verifyPayChecks")
    public String insertPay(@RequestParam("imp_uid")String imp_uid,
                            @RequestParam("totalPrice")int totalPrice,
                            @RequestParam(value = "cartNum[]") List<String> cartNum,
                            @RequestParam("dateString") String dateString,
                            HttpSession session) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        int memberNum = ai.getNo();

        try {

            if (iamportService.confrimBuyerInfo(imp_uid, totalPrice)) {

                iamportService.insertPay(imp_uid, cartNum, totalPrice, dateString, memberNum);
                return "true";

            } else {

                iamportService.cancleBuy(imp_uid,0);
                return "false";

            }

        } catch (Exception e) {

            e.printStackTrace();
            iamportService.cancleBuy(imp_uid,0);
            throw new RuntimeException("insertPay 에서 오류발생");

        }
    }
}
































package team.kyp.kypcoffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import team.kyp.kypcoffee.config.auth.LoginUser;
import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.domain.RegisterRequest;
import team.kyp.kypcoffee.exception.AlreadyExistingMemberException;
import team.kyp.kypcoffee.service.MemberRegisterService;

import team.kyp.kypcoffee.validator.RegisterRequestValidator;

import javax.servlet.http.HttpSession;


@Controller
public class MemberController {

    @Autowired
    private MemberRegisterService memberRegisterService;


    @GetMapping("memberList") //멤버리스트
    public String memberList(Model model) {

//        List<Member> list = service.selectAllMember();
//
//        model.addAttribute("memberList", list);

        return "memberList";
    }


    /////회원가입기능////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/register/agreement") //약관동의 폼으로 이동
    public String agreement1(Model model) {
        return "register/agreement";
    }

    @GetMapping("/register/agreement2") //잘못된경로접속시
    public String getagreement2(Model model) {
        return "register/selection";
    }


    @RequestMapping(value="/register/agreement2", method= RequestMethod.POST)//약관동의시 회원가입 선택 폼으로 이동
    public String agreement2(@RequestParam(value="agree",defaultValue="false") Boolean agree, Model model,
                             @LoginUser SessionUser user, HttpSession session) {
        //SessionUser user = (SessionUser) session.getAttribute("user");

        if(!agree) {
            return "redirect:/register/agreement"; //동의안하면 약관폼에 그대로 있기
        }

        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("userImg", user.getPicture());
        }

            return "register/selection";
    }

    @GetMapping("/register/register")
    public String selection(Model model) {
        model.addAttribute("registerForm",new RegisterRequest());  //작성폼 받아오기
        return "register/register";
    }

    @RequestMapping(value="/register/register", method= RequestMethod.POST) //회원가입 실행-db전송
    public String register(RegisterRequest regReq, Errors errors,Model model, HttpSession session,@LoginUser SessionUser user) {
        //SessionUser user = (SessionUser) session.getAttribute("user");
        System.out.println("폼 정보받아오기 테스트"+ regReq.getName() + +regReq.getEmailyn()+ regReq.getType());

        new RegisterRequestValidator().validate(regReq, errors);

        if(errors.hasErrors()) {
            return "register/register";
        }

        try {

            memberRegisterService.register(regReq);

            session.setAttribute("newMember", regReq);

            if(user != null) {
                model.addAttribute("userName", user.getName());
                model.addAttribute("email", user.getEmail());
                model.addAttribute("userImg", user.getPicture());
            }
            System.out.println("세션저장/회원가입 완료");


            return "register/complete";

        }catch(AlreadyExistingMemberException e) {
            //errors.rejectValue("email", "duplicate"); //메세지 수정해야함
            return "register/register";
        }


    }
///////////////////////////사업자회원가입
    @GetMapping("/register/businessAuthForm")
    public String business(Model model) {

        return "register/businessAuth"; //사업자 인증폼으로 이동
    }

//    @PostMapping("/register/businessConfirm")
//    public String sendnum(@RequestParam("valid") String valid,Model model) {
//
//        model.addAttribute("validation",valid);
//        System.out.println(valid);
//        return valid; //사업자 인증폼으로 이동
//    }
    @GetMapping("/register/businessRegister")
    public String businessregi(Model model) {
        model.addAttribute("businessForm",new RegisterRequest());  //작성폼 받아오기

        return "register/business"; //회원가입폼으로 이동
    }

    @RequestMapping(value="/register/businessAuth", method= RequestMethod.POST) //회원가입폼 전송받음. -db전송
    public String businessregister(RegisterRequest regReq, Errors errors,Model model, HttpSession session,@LoginUser SessionUser user) {
        //SessionUser user = (SessionUser) session.getAttribute("user");
        System.out.println("폼 정보받아오기 테스트"+ regReq.getName() + +regReq.getEmailyn());

        new RegisterRequestValidator().validate(regReq, errors);

        if(errors.hasErrors()) {
            return "register/business";
        }

        try {

            memberRegisterService.register(regReq);

            session.setAttribute("newMember", regReq);

            if(user != null) {
                model.addAttribute("userName", user.getName());
                model.addAttribute("email", user.getEmail());
                model.addAttribute("userImg", user.getPicture());//구글 로그인 정보 전송
            }
            System.out.println("세션저장/회원가입 완료");


            return "register/complete";

        }catch(AlreadyExistingMemberException e) {
            //errors.rejectValue("email", "duplicate"); //메세지 수정해야함
            return "register/register";
        }


    }


}

package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.RegisterRequest;
import team.kyp.kypcoffee.exception.AlreadyExistingMemberException;
import team.kyp.kypcoffee.service.MemberRegisterService;

import team.kyp.kypcoffee.validator.RegisterRequestValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberRegisterService memberRegisterService;


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
                             HttpSession session) {

        if(!agree) {
            return "redirect:/register/agreement"; //동의안하면 약관폼에 그대로 있기
        }

            return "register/selection";
    }

    @GetMapping("/register/register")
    public String selection(Model model) {
        model.addAttribute("registerForm",new RegisterRequest());  //작성폼 받아오기
        return "register/register";
    }

    @RequestMapping("/register/validateId")
    @ResponseBody
    public HashMap<String, Object> validate(Model model, @RequestBody RegisterRequest regReq,
                                 HttpServletRequest request) {

        String memberId=regReq.getId(); //제이슨에서 받아온 정보=입력한 아이디

        Member member= memberRegisterService.selectById(memberId);

        String valid = member.getMemberId();

        if(!valid.equals("1")){
            System.out.print("아이디 중복");
        }else if(valid.equals("1")){
            System.out.print("아이디 사용 가능");
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("valid",valid); // DB에 존재하는 아이디인지?
        System.out.print(map);


        return map;
    }

    @RequestMapping("/register/validateEmail")
    @ResponseBody
    public HashMap<String, Object> validateEmail(Model model, @RequestBody RegisterRequest regReq,
                                            HttpServletRequest request) {

        String memberEmail=regReq.getEmail(); //제이슨에서 받아온 정보=입력한 이메일

        Member member= memberRegisterService.selectByEmail(memberEmail);

        String validEmail = member.getMemberEmail();

        if(!validEmail.equals("1")){
            System.out.print("이메일 중복");
        }else if(validEmail.equals("1")){
            System.out.print("이메일 사용 가능");
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("validEmail",validEmail); // DB에 존재하는 아이디인지?
        System.out.print(map);


        return map;
    }

    @ResponseBody
    @RequestMapping(value="/member/loginGoogle", method= RequestMethod.POST) //json으로 받아옴
    public HashMap<String, Object> registerGoogle(Errors errors,Model model, HttpSession session,
                                 SessionUser user,@RequestBody Member member) {

    //user = (SessionUser) session.getAttribute("user");
        String memberEmail=member.getMemberEmail();
        String memberName=member.getMemberName();

        System.out.print("구글로그인 정보 가져오기"+ memberEmail+memberName);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("memberEmail",memberEmail);
        System.out.print(map);

        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("userImg", user.getPicture());
        }
        System.out.print("이건 어디서 가져온다는거지?"+ user);
    return map;
    }


    @RequestMapping(value="/register/register", method= RequestMethod.POST) //회원가입 실행-db전송
    public String register(RegisterRequest regReq, Errors errors,Model model, HttpSession session) {

        System.out.println("폼 정보받아오기 테스트"+ regReq.getName() + +regReq.getEmailyn()+ regReq.getType());

        new RegisterRequestValidator().validate(regReq, errors);

        if(errors.hasErrors()) {
            return "register/register";
        }

        try {
            memberRegisterService.register(regReq);
            session.setAttribute("newMember", regReq);
            System.out.println("세션저장/회원가입 완료");
            return "register/success";

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

    @GetMapping("/register/businessRegister")
    public String businessregi(Model model) {
        model.addAttribute("businessForm",new RegisterRequest());  //작성폼 받아오기

        return "register/business"; //회원가입폼으로 이동
    }

    @RequestMapping(value="/register/businessAuth", method= RequestMethod.POST) //회원가입폼 전송받음. -db전송
    public String businessregister(RegisterRequest regReq, Errors errors, Model model, HttpSession session) {

        System.out.println("폼 정보받아오기 테스트"+ regReq.getName() + +regReq.getEmailyn());

        new RegisterRequestValidator().validate(regReq, errors);

        if(errors.hasErrors()) {
            return "register/business";
        }

        try {
            memberRegisterService.register(regReq);
            session.setAttribute("newMember", regReq);
            System.out.println("세션저장/회원가입 완료");

            return "register/success";

        }catch(AlreadyExistingMemberException e) {
            //errors.rejectValue("email", "duplicate"); //메세지 수정해야함
            return "register/register";
        }


    }


}

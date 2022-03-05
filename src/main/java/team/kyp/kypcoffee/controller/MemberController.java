package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.Member;
import team.kyp.kypcoffee.domain.RegisterRequest;
import team.kyp.kypcoffee.domain.User.Kakao;
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

    @GetMapping("/register/success")
    public String success(Model model) {
        return "register/success";
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

    @RequestMapping(value="/register/register", method= RequestMethod.POST) //회원가입 실행-db전송
    public String register(RegisterRequest regReq, Errors errors,Model model, HttpSession session) {

        System.out.println("폼 정보받아오기 테스트"+ regReq.getName() + +regReq.getEmailyn()+ regReq.getType());

        new RegisterRequestValidator().validate(regReq, errors);

        if(errors.hasErrors()) {
            return "register/register";
        }

        try {
            memberRegisterService.register(regReq);
            System.out.println("세션저장/회원가입 완료");

            return "register/success";

        }catch(AlreadyExistingMemberException e) {
            //errors.rejectValue("email", "duplicate"); //메세지 수정해야함
            return "register/register";
        }


    }

    @RequestMapping(value="/updateInfo", method= RequestMethod.GET) //회원정보수정
    public String update(Model model,
                         HttpSession session, Member member) {

        model.addAttribute("updateForm",new RegisterRequest());

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        if(ai!=null){
            member = memberRegisterService.selectByMnum(ai.getNo());//정보수정할 회원정보 보여주기
            model.addAttribute("member", member);
        }

        return "member/update";
    }

    @RequestMapping(value="/updateInfo", method= RequestMethod.POST) //폼에서 받아와서 회원정보수정
    public String updateInfo(RegisterRequest regReq, Model model, HttpSession session) {

        memberRegisterService.update(regReq);
        System.out.println("세션저장 / 회원정보수정 완료");
        return "/mypageKakao";

    }

    @RequestMapping(value="/updateInfoKakao", method= RequestMethod.GET) //카카오 회원정보수정
    public String updateKakao(Model model, HttpSession session, Member member) {

        model.addAttribute("updateForm",new RegisterRequest());

        Kakao kakao = (Kakao) session.getAttribute("kakao");

        if(kakao!=null){
            member = memberRegisterService.selectByEmailOnly(kakao.getEmail());//정보수정할 회원정보 보여주기
            model.addAttribute("member", member);
        }

        return "member/updateKakao";
    }


    @RequestMapping(value="/updateInfoKakao", method= RequestMethod.POST) //폼에서 받아와서 회원정보수정
    public String updateInfoKakao(RegisterRequest regReq, Model model, Errors errors, HttpSession session) {

        if(errors.hasErrors()) {
            return "/mypageKakao";
        }
        memberRegisterService.updateGoogle(regReq);
        System.out.println("세션저장 / 회원정보수정 완료");

        return "/mypageKakao";

    }


    @RequestMapping(value="/updateInfoGoogle", method= RequestMethod.GET) //구글회원정보수정
    public String updateGoogle(Model model, HttpSession session, Member member) {

        model.addAttribute("updateForm",new RegisterRequest());

        SessionUser user = (SessionUser) session.getAttribute("user");

        if(user!=null){
            member = memberRegisterService.selectByEmailOnly(user.getEmail());//정보수정할 회원정보 보여주기
            model.addAttribute("member", member);
        }

        return "member/updateGoogle";
    }


    @RequestMapping(value="/updateInfoGoogle", method= RequestMethod.POST) //폼에서 받아와서 회원정보수정
    public String updateInfoGoogle(RegisterRequest regReq, Model model, Errors errors, HttpSession session) {

         if(errors.hasErrors()) {
            return "/mypageGoogle";
        }
        memberRegisterService.updateGoogle(regReq);
        System.out.println("세션저장 / 회원정보수정 완료");

        return "/mypageGoogle";

    }

    @GetMapping("/unregister") //다시묻기로 이동
    public String unregister(Model model) {
        return "member/unregister";
    }

    @GetMapping("/unregister2") //일반회원탈퇴진행
    public String unregister2(Model model,HttpSession session) {

        AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

        memberRegisterService.delete(ai.getNo());
        session.invalidate(); //세션에 저장된 모든 데이터를 제거

        return "member/unregisterSuccess";
    }

    @GetMapping("/unregisterGoogle") //구글회원탈퇴진행
    public String unregisterGoogle(Model model,HttpSession session) {

        SessionUser user = (SessionUser) session.getAttribute("user");

        memberRegisterService.deleteGoogle(user.getEmail());
        session.removeAttribute("user"); //세션 지우기

        return "member/unregisterSuccess";
    }

    @GetMapping("/unregisterKakao") //카카오 회원탈퇴진행
    public String unregisterKakao(Model model,HttpSession session) {

        Kakao kakao = (Kakao) session.getAttribute("kakao");

        memberRegisterService.deleteGoogle(kakao.getEmail());
        session.removeAttribute("kakao"); //세션 지우기

        return "member/unregisterSuccess";
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
            System.out.println("세션저장/회원가입 완료");

            return "register/success";

        }catch(AlreadyExistingMemberException e) {
            //errors.rejectValue("email", "duplicate"); //메세지 수정해야함
            return "register/register";
        }


    }


}

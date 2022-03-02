package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.LoginCommand;
import team.kyp.kypcoffee.exception.IdPasswordNotMatchingException;
import team.kyp.kypcoffee.service.AuthService;
import team.kyp.kypcoffee.validator.LoginCommandValidator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final AuthService authService;

    @GetMapping("/signin" )
    public String login(Model model,@CookieValue(value="rememberId", required=false) Cookie cookie) {

        model.addAttribute("loginCommand", new LoginCommand());

        if(cookie!=null) {
            System.out.println("쿠키값"+cookie.getValue());
            String cookieval=cookie.getValue();
            model.addAttribute("cookie",cookieval); //쿠키저장되어있으면 모델에 전달
        }

        return "signin/loginForm";
    }

    @RequestMapping("/signout")
    public String logout(HttpSession session) {
        session.invalidate(); //세션에 저장된 모든 데이터를 제거
        return "redirect:/";
    }

    @GetMapping("/signin/loginFailure") //로그인 실패 페이지
    public String loginFail(Model model) {

        return "signin/loginFailure";
    }

    @GetMapping("/signin/loginSuccess")
    public String loginSuccess(Model model) {

        return "signin/loginSuccess";

    } //로그인 폼으로 이동

    @GetMapping("/signin/googleLogin")
    public String googleLogin(Model model) {

        return "signin/googleLogin";
    } //로그인 폼으로 이동

    @GetMapping("/signin/googleOut")
    public String googleLogout(Model model) {

        return "signin/googleOut";
    }


    @RequestMapping(value = "/signin/loginExecute", method = RequestMethod.POST)
    public String submit(LoginCommand loginCommand, Errors errors, HttpSession session,
                         @RequestParam(value="rememberlogin",required=false) Boolean rememberlogin,
                         HttpServletResponse response, Model model) { // 폼에서 로그인 기능을 요청

        //이메일, 비밀번호가 입력이 제대로 되었는지 검증
        new LoginCommandValidator().validate(loginCommand, errors);

        if (errors.hasErrors()) {
            return "signin/loginForm";
        }

        try {
            if(rememberlogin!=null) {// 아이디 비밀번호 기억 체크 되어있다면 쿠키생성
                Cookie rememberId = new Cookie("rememberId", loginCommand.getId());
                rememberId.setMaxAge(60 * 10);
                rememberId.setPath("/");
                response.addCookie(rememberId);

            }else if(rememberlogin==null){
                Cookie deleteId = new Cookie("rememberId", null) ;
                deleteId.setMaxAge(0) ;
                response.addCookie(deleteId) ;
            }


            AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getName(), loginCommand.getNo(),
                   loginCommand.getPw());

            // 로그인 정보를 기록할 세션 코드
            session.setAttribute("authInfo", authInfo);

            //구글 로그인정보 가져오기
//            AuthInfo ai = (AuthInfo) session.getAttribute("user");
//            model.addAttribute("user", ai.getName());

            return "signin/loginSuccess";

        } catch (IdPasswordNotMatchingException e) {
            //이메일이 없거나, 비밀번호가 틀린경우
            //errors.reject("idPasswordNotMatching");
            return "signin/loginForm";
        }


    }
}

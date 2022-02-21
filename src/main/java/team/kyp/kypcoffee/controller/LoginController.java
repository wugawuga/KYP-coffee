package team.kyp.kypcoffee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.kyp.kypcoffee.domain.AuthInfo;
import team.kyp.kypcoffee.domain.LoginCommand;
import team.kyp.kypcoffee.exception.IdPasswordNotMatchingException;
import team.kyp.kypcoffee.service.AuthService;
import team.kyp.kypcoffee.validator.LoginCommandValidator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class LoginController {
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Autowired
    private AuthService authService;

    /////로그인기능////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/signin")
    public String login(Model model) {

        model.addAttribute("loginCommand", new LoginCommand());

        return "login/login";
    } //로그인 폼으로 이동

    @RequestMapping(value = "/login/loginExecute", method = RequestMethod.POST)
    public String submit(LoginCommand loginCommand, Errors errors, HttpSession session,
                         @CookieValue(value="l", required=false) Cookie rememberlogin, HttpServletResponse response, Model model) { // 폼에서 로그인 기능을 요청
        //1. 이메일, 비밀번호가 입력이 제대로 되었는지 검증

        new LoginCommandValidator().validate(loginCommand, errors);

        if (errors.hasErrors()) {
            return "login/login";
        }

        // 2. 입력 받은 아이디 비밀번호로 로그인 (서비스 객체)시도
        try {
            Cookie rememberId = new Cookie("rememberId",loginCommand.getId());
            Cookie rememberPw = new Cookie("rememberPw",loginCommand.getPw());

            System.out.println("authservice 전 정상 작동");
            AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getName(), loginCommand.getNo(),
                    loginCommand.getPw());
            System.out.println("authservice 정상 작동");

            // 로그인 정보를 기록할 세션 코드
            session.setAttribute("authInfo", authInfo);

            // 현재로그인된 정보알아오기
            AuthInfo ai = (AuthInfo) session.getAttribute("authInfo");

            model.addAttribute("loginInfo", ai.getName());

            return "login/loginSuccess";

        } catch (IdPasswordNotMatchingException e) {
            //이메일이 없거나, 비밀번호가 틀린경우
            errors.reject("idPasswordNotMatching");
            return "login/login";
        }


    }
}

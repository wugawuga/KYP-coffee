package team.kyp.kypcoffee.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers( "/login/**","/signin/**","/admin/**","/register/**","/product/**").permitAll() // login URL에는 누구나 접근 가능
                .anyRequest().authenticated() // 그 이외에는 인증된 사용자만 접근 가능
                .and()
                .logout()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(UserService);
    }
}
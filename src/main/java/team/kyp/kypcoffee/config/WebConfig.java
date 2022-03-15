package team.kyp.kypcoffee.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //외부에 있는 상품이미지 저장폴더 경로 설정하기
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        // addResourceHandler : 스프링부트에서 확인할 폴더 위치 설정
        // addResourceLocations : 실제 시스템의 폴더 위치

        registry.addResourceHandler("/productImg/**").addResourceLocations("file:///C:/productImg/");
        registry.addResourceHandler("/reviewImg/**").addResourceLocations("file:///C:/reviewImg/");

        // 맥북 파일경로 설정
        //registry.addResourceHandler("/productImg/**").addResourceLocations("맥북파일경로");
    }

}


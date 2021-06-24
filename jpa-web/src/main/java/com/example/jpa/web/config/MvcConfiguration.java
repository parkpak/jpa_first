package com.example.jpa.web.config;

import com.example.jpa.web.common.interceptor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.example.jpa.web.common.constant.HtmlUriConstant.*;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 일반 로깅
        registry.addInterceptor(new LoggerInterceptor())
                .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**");

        // 로그인 완료 후 세션 저장
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(URI_LOGIN);

        // 로그인 사용자 접근 체크
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns(URI_EMPLOYEE_WRITE);

        // 로그아웃 완료 후 세션 삭제
        registry.addInterceptor(new LogoutInterceptor())
                .addPathPatterns(URI_LOGOUT);

        // 회원정보
        registry.addInterceptor(new UserInterceptor())
                .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**");
    }
}

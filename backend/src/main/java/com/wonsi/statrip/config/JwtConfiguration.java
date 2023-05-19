//package com.wonsi.statrip.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class JwtConfiguration implements WebMvcConfigurer {
//	
//    @Autowired
//    private JwtInterceptor jwtInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor)
//        .excludePathPatterns("/user/login"); // 제외할 경로 패턴 지정
////                .addPathPatterns("/vue/**") // 적용할 경로 패턴 지정
//    }
//}
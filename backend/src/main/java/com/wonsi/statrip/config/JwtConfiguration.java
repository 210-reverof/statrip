package com.wonsi.statrip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wonsi.statrip.interceptor.JwtInterceptor;

public class JwtConfiguration implements WebMvcConfigurer {
}
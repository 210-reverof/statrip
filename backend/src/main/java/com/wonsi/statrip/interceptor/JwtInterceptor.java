package com.wonsi.statrip.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wonsi.statrip.exception.UnAuthorizedException;
import com.wonsi.statrip.model.service.JwtService;

import java.util.Enumeration;

@Component
public class JwtInterceptor implements HandlerInterceptor {

	public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

	private static final String HEADER_AUTH = "auth-token";

	@Autowired
	private JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);
		System.out.println("hellllo" + request.getHeader(HEADER_AUTH));
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println("=====" + headerName + " : " + request.getHeader(headerName));
		}
		
		if (token == null) {
			logger.info("토큰 사용 불가능 : {}", token);
			throw new UnAuthorizedException("사용 불가 토큰");
		}
		
		String userId = jwtService.getUserId();
		if (userId == null) {
			logger.info("토큰 사용 불가능 : {}", token);
			throw new UnAuthorizedException("사용 불가능 토큰");
		}
		
		logger.info("토큰 사용 가능 : {}", token);
		request.setAttribute("userId", userId);
		return true;

	}

}

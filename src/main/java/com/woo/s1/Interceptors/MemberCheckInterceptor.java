package com.woo.s1.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// Controller 진입 전
		// return이 true라면 다음 Controller로 진행
		// return이 true라면 다음 Controller로 진행 X
		System.out.println("Controller 진입 전 체크");
		response.sendRedirect("");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// Controller에서 리턴 후 DS 전
		System.out.println("Controller에 리턴 후 DS 진입 전");
	}
		
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		// JSP 렌더링 후
		System.out.println("JSP 렌더링 후");
	}
	
	
	
}

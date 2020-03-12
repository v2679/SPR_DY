package com.dy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final String LOGIN = "login";
	//login 한 후
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView mv)throws Exception{
		HttpSession session = request.getSession();
		Object MemberVO = mv.getModelMap().get("memberVO");
		
		FlashMap flashMap = new FlashMap();
		FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		/*
		
		*/
		System.out.println("interceptor postHandle="+MemberVO);
		if(MemberVO!=null) {//로그인
			System.out.println("aaaa");
			session.setAttribute(LOGIN, MemberVO);//로그인 처리
			System.out.println("bbb="+session.getAttribute(LOGIN));
			response.sendRedirect("/kdy/member/home");//로그인 성공한 후 홈페이지로 이동
		}else{
			response.sendRedirect("/kdy/member/login");
		}
	}
	//login 하기 전
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN)!=null) {//기존에 로그인이 되어있다면
			session.removeAttribute(LOGIN);//로그아웃
		}
		return true;
	}
}

package com.iu.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.b1.member.MemberVO;

@Component
public class NoticeInterCeptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO");
		if(memberVO!=null) {
			if(memberVO.getId().equals("admin")) {
				return true;
			}
			response.sendRedirect("../");
			return false;
		}else {
			response.sendRedirect("../");
			return false;
		}
	}
}

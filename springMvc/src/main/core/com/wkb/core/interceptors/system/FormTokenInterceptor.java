package com.wkb.core.interceptors.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wkb.common.util.Constant;
import com.wkb.core.annotations.NoFormToken;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 基础平台登录验证
 * @author luo
 *
 */
public class FormTokenInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 是否登陆验证
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String method = request.getMethod();
		//如果是get请求
		if(Constant.COMMON.REQUEST_GET_NAME.equals(method)){
			return true;
		}
		//如果注解中要求不验证登陆则直接通过
		HandlerMethod hm=(HandlerMethod)handler;
		if(hm.getBean().getClass().isAnnotationPresent(NoFormToken.class) || hm.getMethod().isAnnotationPresent(NoFormToken.class)){
			return true;
		}
		HttpSession session=request.getSession();
		String reToken = request.getParameter(Constant.COMMON.FORM_TOKEN_NAME);
		String seToken = (String) session.getAttribute(Constant.COMMON.FORM_TOKEN_NAME);
		session.removeAttribute(Constant.COMMON.FORM_TOKEN_NAME);
		if(!seToken.equals(reToken)){
			return false;
		}
		return true;
	}

}

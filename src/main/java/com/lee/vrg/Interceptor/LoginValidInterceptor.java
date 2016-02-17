package com.lee.vrg.Interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.netlib.util.booleanW;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.exception.RequestException;

public class LoginValidInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		LoginValid annotation = method.getAnnotation(LoginValid.class);
		if (annotation != null) {
			boolean isLogin = false;
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("UserAgent")) {
					isLogin = true;
				}
			}
			if (!isLogin) {
				throw new BaseVrgException("-9", "user.need.login");
			}
		}
		// 没有注解通过拦截
		return true;
	}
}
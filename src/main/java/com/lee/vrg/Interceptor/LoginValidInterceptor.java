package com.lee.vrg.Interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.util.StringUtil;

/**
 * 登录判断拦截器，简单判断userAgent是否存在，userAgent数据是否有效需要UserAgentArgumentResolver解析判断
 * 
 * @author dell
 *
 */
public class LoginValidInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (!handler.getClass().equals(HandlerMethod.class)) {
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		LoginValid annotation = method.getAnnotation(LoginValid.class);

		if (annotation != null) {
			boolean isLogin = false;

			// 登录信息可以存cookie 也可以通过head带过来
			if (StringUtil.isNotBlank(request.getHeader("UserAgent"))) {
				isLogin = true;
			}
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
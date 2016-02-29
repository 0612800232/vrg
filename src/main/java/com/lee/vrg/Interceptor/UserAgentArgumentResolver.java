package com.lee.vrg.Interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.alibaba.fastjson.JSON;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.util.StringUtil;
import com.lee.vrg.util.DESUtil;

/**
 * 
 * @author dell
 *
 */
@Service
public class UserAgentArgumentResolver implements WebArgumentResolver {

	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		if (methodParameter.getParameterType().equals(UserAgent.class)) {

			HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

			if (StringUtil.isNotBlank(request.getHeader("UserAgent"))) {
				try {
					UserAgent userAgent = JSON.parseObject(DESUtil.decrypt(request.getHeader("UserAgent")),
							UserAgent.class);
					return userAgent;
				} catch (Exception e) {
					throw new BaseVrgException("-9", "user.need.login");
				}
			}

			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("UserAgent")) {
					try {
						UserAgent userAgent = JSON.parseObject(DESUtil.decrypt(cookie.getValue()), UserAgent.class);
						return userAgent;
					} catch (Exception e) {
						cookie.setMaxAge(1);
						throw new BaseVrgException("-9", "user.need.login");
					}
				}
			}

		}
		return UNRESOLVED;
	}

}

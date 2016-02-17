package com.lee.vrg.action;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lee.vrg.Interceptor.LoginValid;
import com.lee.vrg.Interceptor.UserAgent;
import com.lee.vrg.common.bo.ResponeBo;
import com.lee.vrg.common.bo.UserBo;
import com.lee.vrg.common.service.UserService;
import com.lee.vrg.util.DESUtil;

/**
 * 对外提供http 的api
 * 
 * @author liwenjing
 *
 */
@Controller
@RequestMapping("/api/user")
public class UserApiAction extends BaseAction {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/regist.json", method = POST)
	@ResponseBody
	public ResponeBo regist(@Valid UserBo user, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		userService.regiestUsers(user);
		responeBo.setData(user);
		responeBo.setMessage(getLoclMsg("user.regist.success", request));

		UserAgent userAgent = new UserAgent();
		userAgent.setId(user.getId());
		Cookie cookie = new Cookie("UserAgent", DESUtil.encrypt(JSON.toJSONString(userAgent)));
		cookie.setDomain("51go2.com");
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		return responeBo;
	}

	@RequestMapping(value = "/login.json", method = POST)
	@ResponseBody
	public ResponeBo login(@Valid UserBo user, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResponeBo responeBo = new ResponeBo();
		user = userService.loginUsers(user);
		responeBo.setData(user);
		responeBo.setMessage(getLoclMsg("user.login.success", request));

		UserAgent userAgent = new UserAgent();
		userAgent.setId(user.getId());
		Cookie cookie = new Cookie("UserAgent", DESUtil.encrypt(JSON.toJSONString(userAgent)));
		cookie.setDomain("127.0.0.1");
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		return responeBo;
	}

	@LoginValid
	@RequestMapping(value = "/query.json", method = GET)
	@ResponseBody
	public ResponeBo query(UserAgent userAgent, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(userService.getUser(userAgent.getId()));
		return responeBo;
	}

	@LoginValid
	@RequestMapping(value = "/update.json", method = PUT)
	@ResponseBody
	public ResponeBo update(UserAgent userAgent, @Valid UserBo user, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		requestValid(result, request);
		ResponeBo responeBo = new ResponeBo();
		user.setId(userAgent.getId());
		responeBo.setMessage(getLoclMsg("user.update.success", request));
		responeBo.setData(userService.update(user));
		return responeBo;
	}

}

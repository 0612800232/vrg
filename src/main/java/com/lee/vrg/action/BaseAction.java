package com.lee.vrg.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.lee.vrg.common.bo.ResponeBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.util.StringUtil;
import com.lee.vrg.exception.RequestException;

@Controller
public class BaseAction {
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	@Autowired
	CookieLocaleResolver localeResolver;

	/**
	 * 用于处理异常的
	 * 
	 * @return
	 */
	@ExceptionHandler({ RequestException.class })
	@ResponseBody
	public ResponeBo exception(RequestException e) {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setCode(e.getCode());
		responeBo.setMessage(e.getErrorMsg());
		return responeBo;
	}

	/**
	 * 用于处理异常的
	 * 
	 * @return
	 */
	@ExceptionHandler({ BaseVrgException.class })
	@ResponseBody
	public ResponeBo baseException(BaseVrgException e, HttpServletRequest request) {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setCode(e.getCode());
		responeBo.setMessage(getLoclMsg(e.getErrorMsg(), request));
		return responeBo;
	}

	public String getLoclMsg(String code, HttpServletRequest request) {
		return messageSource.getMessage(code, null, code, localeResolver.resolveLocale(request));
	}

	public void requestValid(BindingResult result, HttpServletRequest request) throws RequestException {
		if (result.hasErrors()) {

			String errorMsg = "";
			for (FieldError error : result.getFieldErrors()) {

				if (StringUtil.isNotBlank(error.getDefaultMessage())) {
					String code = error.getDefaultMessage();
					String errorMsgLocal = messageSource.getMessage(code, error.getArguments(),
							error.getDefaultMessage(), localeResolver.resolveLocale(request));
					errorMsg = errorMsg + errorMsgLocal + ";";
				} else {
					String fieldName = error.getObjectName() + "." + error.getField();
					String fieldNameLocal = messageSource.getMessage(fieldName, error.getArguments(),
							error.getDefaultMessage(), localeResolver.resolveLocale(request));
					String errorMsgLocal = messageSource.getMessage(error.getCode(), error.getArguments(),
							error.getDefaultMessage(), localeResolver.resolveLocale(request));
					errorMsg = errorMsg + fieldNameLocal + errorMsgLocal + ";";
				}

			}
			RequestException exception = new RequestException("-1", errorMsg);
			throw exception;
		}
	}
}

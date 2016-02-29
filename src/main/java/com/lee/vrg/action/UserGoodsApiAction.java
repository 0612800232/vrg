package com.lee.vrg.action;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.vrg.Interceptor.LoginValid;
import com.lee.vrg.Interceptor.UserAgent;
import com.lee.vrg.common.bo.ResponeBo;
import com.lee.vrg.common.bo.UserGoodsBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.service.UserGoodsService;

@Controller
@RequestMapping("/api/user_goods")
public class UserGoodsApiAction extends BaseAction {
	@Autowired
	UserGoodsService userGoodsService;

	@RequestMapping(value = "/get.json", method = GET)
	@ResponseBody
	@LoginValid
	public ResponeBo get(Long id) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(userGoodsService.get(id));
		return responeBo;
	}

	@RequestMapping(value = "/query.json")
	@ResponseBody
	@LoginValid
	public ResponeBo query(UserGoodsBo UserGoodsBo) {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(userGoodsService.query(UserGoodsBo));
		return responeBo;
	}

	@RequestMapping(value = "/insert.json", method = POST)
	@ResponseBody
	@LoginValid
	public ResponeBo insert(UserAgent userAgent, @Valid UserGoodsBo UserGoodsBo, BindingResult result,
			HttpServletRequest request) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		UserGoodsBo.setUserId(userAgent.getId());
		responeBo.setData(userGoodsService.insert(UserGoodsBo));
		return responeBo;
	}

	@RequestMapping(value = "/update.json", method = PUT)
	@ResponseBody
	@LoginValid
	public ResponeBo update(@Valid UserGoodsBo UserGoodsBo, BindingResult result, HttpServletRequest request)
			throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		responeBo.setData(userGoodsService.update(UserGoodsBo));
		return responeBo;
	}

	@RequestMapping(value = "/delete.json", method = DELETE)
	@ResponseBody
	@LoginValid
	public ResponeBo delete(Long id, HttpServletRequest request) {
		ResponeBo responeBo = new ResponeBo();
		boolean result = userGoodsService.delete(id);
		responeBo.setCode(result ? "0" : "-1");
		responeBo
				.setMessage(result ? getLoclMsg("goods.del.success", request) : getLoclMsg("goods.del.error", request));
		return responeBo;
	}

}

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
import com.lee.vrg.common.bo.GoodsBo;
import com.lee.vrg.common.bo.ResponeBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.service.GoodsService;

@Controller
@RequestMapping("/api/goods")
public class GoodsApiAction extends BaseAction {
	@Autowired
	GoodsService goodsService;

	@RequestMapping(value = "/get.json", method = GET)
	@ResponseBody
	@LoginValid
	public ResponeBo get(Integer id) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(goodsService.get(id));
		return responeBo;
	}

	@RequestMapping(value = "/query.json")
	@ResponseBody
	@LoginValid
	public ResponeBo query(GoodsBo goodsBo) {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(goodsService.query(goodsBo));
		return responeBo;
	}

	@RequestMapping(value = "/insert.json", method = POST)
	@ResponseBody
	@LoginValid
	public ResponeBo insert(UserAgent userAgent, @Valid GoodsBo goodsBo, BindingResult result,
			HttpServletRequest request) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		goodsBo.setCreaterId(userAgent.getId());
		responeBo.setData(goodsService.insert(goodsBo));
		return responeBo;
	}

	@RequestMapping(value = "/update.json", method = PUT)
	@ResponseBody
	@LoginValid
	public ResponeBo update(@Valid GoodsBo goodsBo, BindingResult result, HttpServletRequest request)
			throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		responeBo.setData(goodsService.update(goodsBo));
		return responeBo;
	}

	@RequestMapping(value = "/delete.json", method = DELETE)
	@ResponseBody
	@LoginValid
	public ResponeBo delete(Integer id, HttpServletRequest request) {
		ResponeBo responeBo = new ResponeBo();
		boolean result = goodsService.delete(id);
		responeBo.setCode(result ? "0" : "-1");
		responeBo.setMessage(result ? getLoclMsg("goods.del.success", request)
				: getLoclMsg("goods.del.error", request));
		return responeBo;
	}

}

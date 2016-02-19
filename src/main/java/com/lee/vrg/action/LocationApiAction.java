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
import com.lee.vrg.common.bo.LocationBo;
import com.lee.vrg.common.bo.ResponeBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.service.LocationService;

@Controller
@RequestMapping("/api/location")
public class LocationApiAction extends BaseAction {
	@Autowired
	LocationService locationService;

	@RequestMapping(value = "/get.json", method = GET)
	@ResponseBody
	@LoginValid
	public ResponeBo get(Long id) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(locationService.get(id));
		return responeBo;
	}

	@RequestMapping(value = "/query.json")
	@ResponseBody
	@LoginValid
	public ResponeBo query(LocationBo locationBo) {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(locationService.query(locationBo));
		return responeBo;
	}

	@RequestMapping(value = "/insert.json", method = POST)
	@ResponseBody
	@LoginValid
	public ResponeBo insert(UserAgent userAgent, @Valid LocationBo locationBo, BindingResult result,
			HttpServletRequest request) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		locationBo.setCreaterId(userAgent.getId());
		responeBo.setData(locationService.insert(locationBo));
		return responeBo;
	}

	@RequestMapping(value = "/update.json", method = PUT)
	@ResponseBody
	@LoginValid
	public ResponeBo update(@Valid LocationBo locationBo, BindingResult result, HttpServletRequest request)
			throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		responeBo.setData(locationService.update(locationBo));
		return responeBo;
	}

	@RequestMapping(value = "/delete.json", method = DELETE)
	@ResponseBody
	@LoginValid
	public ResponeBo delete(Long id, HttpServletRequest request) {
		ResponeBo responeBo = new ResponeBo();
		boolean result = locationService.delete(id);
		responeBo.setCode(result ? "0" : "-1");
		responeBo.setMessage(result ? getLoclMsg("location.del.success", request)
				: getLoclMsg("location.del.error", request));
		return responeBo;
	}

}

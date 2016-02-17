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
import com.lee.vrg.common.bo.LocationTypeBo;
import com.lee.vrg.common.bo.ResponeBo;
import com.lee.vrg.common.exception.BaseVrgException;
import com.lee.vrg.common.service.LocationTypeService;

@Controller
@RequestMapping("/api/location_type")
public class LocationTypeApiAction extends BaseAction {
	@Autowired
	LocationTypeService locationTypeService;

	@RequestMapping(value = "/get.json", method = GET)
	@ResponseBody
	@LoginValid
	public ResponeBo get(Integer id) throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(locationTypeService.get(id));
		return responeBo;
	}

	@RequestMapping(value = "/query.json")
	@ResponseBody
	@LoginValid
	public ResponeBo query(LocationTypeBo locationTypeBo) {
		ResponeBo responeBo = new ResponeBo();
		responeBo.setData(locationTypeService.query(locationTypeBo));
		return responeBo;
	}

	@RequestMapping(value = "/insert.json", method = POST)
	@ResponseBody
	@LoginValid
	public ResponeBo insert(@Valid LocationTypeBo locationTypeBo, BindingResult result, HttpServletRequest request)
			throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		responeBo.setData(locationTypeService.insert(locationTypeBo));
		return responeBo;
	}

	@RequestMapping(value = "/update.json", method = PUT)
	@ResponseBody
	@LoginValid
	public ResponeBo update(@Valid LocationTypeBo locationTypeBo, BindingResult result, HttpServletRequest request)
			throws BaseVrgException {
		ResponeBo responeBo = new ResponeBo();
		requestValid(result, request);
		responeBo.setData(locationTypeService.update(locationTypeBo));
		return responeBo;
	}

	@RequestMapping(value = "/delete.json", method = DELETE)
	@ResponseBody
	@LoginValid
	public ResponeBo delete(Integer id, HttpServletRequest request) {
		ResponeBo responeBo = new ResponeBo();
		boolean result = locationTypeService.delete(id);
		responeBo.setCode(result ? "0" : "-1");
		responeBo.setMessage(result ? getLoclMsg("locationType.del.success", request)
				: getLoclMsg("locationType.del.error", request));
		return responeBo;
	}

}

package com.lee.vrg.action;

/**
 * 返回的对象类
 * 
 * @author dell
 *
 */
public class ResponeBo {
	public String code;
	public String message;
	public Object data;

	public String getCode() {
		return code;
	}

	public ResponeBo() {
		this.code = "0";
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

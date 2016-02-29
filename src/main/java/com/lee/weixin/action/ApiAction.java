package com.lee.weixin.action;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class ApiAction {

	@RequestMapping(value = "/weixin", method = GET)
	public void get(String signature, String timestamp, String nonce, String echostr, HttpServletResponse response)
			throws Exception {

		ArrayList<String> arl = new ArrayList<String>();
		arl.add("abc123");
		arl.add(timestamp);
		arl.add(nonce);
		Collections.sort(arl);

		String tmpStr = "";
		for (String string : arl) {
			tmpStr = tmpStr + string;
		}

		MessageDigest alga = MessageDigest.getInstance("SHA-1");
		alga.update(tmpStr.getBytes());
		byte[] digesta = alga.digest();
		System.out.println("本信息摘要是:" + byte2hex(digesta));

		if (byte2hex(digesta).equals(signature)) {
			System.out.println("信息检查正常");
		} else {
			System.err.println("收到的消息是：" + signature);
			System.out.println("摘要不相同");
		}
		System.out.println(echostr);
		response.getWriter().print(echostr);
	}

	@RequestMapping(value = "/weixin", method = POST)
	public void post(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(requestBody);
		response.getWriter().print("success");
	}

	public String byte2hex(byte[] b) // 二行制转字符串
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toLowerCase();
	}
}

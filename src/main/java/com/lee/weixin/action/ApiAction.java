package com.lee.weixin.action;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/weixin")
public class ApiAction {

	@RequestMapping(value = "/checkServer.json", method = GET)
	@ResponseBody
	public String get(String signature, String timestamp, String nonce, String echostr) throws Exception {

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
			System.err.println("收到的消息是：" + signature );
			System.out.println("摘要不相同");
		}
		System.out.println(echostr);
		return echostr;
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

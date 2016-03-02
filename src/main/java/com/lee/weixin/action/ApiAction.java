package com.lee.weixin.action;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.weixin.bo.Wxmessage;

@Controller
@RequestMapping("/api/")
public class ApiAction {
	Logger log = Logger.getLogger(ApiAction.class);

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
	@ResponseBody
	public String post(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(requestBody);
		String responeBody = sendMessage(getWxMessage(requestBody), response);
		log.info(responeBody);
		return responeBody;
	}

	String sendMessage(Wxmessage wxmessage, HttpServletResponse response) throws Exception {

		Document xml = DocumentHelper.createDocument();
		Element root = xml.addElement("xml");

		Element ToUserName = root.addElement("ToUserName");
		ToUserName.setText(addText(wxmessage.getFromUserName()));

		Element FromUserName = root.addElement("FromUserName");
		FromUserName.setText(addText(wxmessage.getToUserName()));

		Element CreateTime = root.addElement("CreateTime");
		CreateTime.setText(addText(String.valueOf(new Date().getTime())));

		Element MsgType = root.addElement("MsgType");
		MsgType.setText(addText("text"));

		Element Content = root.addElement("Content");
		String content = "address:" + wxmessage.getLabel() + ";x:" + wxmessage.getLocation_X() + ";y:"
				+ wxmessage.getLocation_Y() + ";scale:" + wxmessage.getScale();
		Content.setText(addText(content));
		return xml.asXML().substring(39);
	}

	String addText(String text) {
		return text;
	}

	Wxmessage getWxMessage(String requestBody) throws Exception {
		Wxmessage wx = new Wxmessage();
		Document xml = DocumentHelper.parseText(requestBody);
		wx.ToUserName = xml.getRootElement().elementTextTrim("ToUserName");
		wx.FromUserName = xml.getRootElement().elementTextTrim("FromUserName");
		wx.MsgType = xml.getRootElement().elementTextTrim("MsgType");
		log.info("MsgType:" + wx.MsgType);
		if ("event".equals(wx.MsgType.trim())) {
			wx.EventName = xml.getRootElement().elementTextTrim("Event");
			log.info(wx.EventName);
			if ("LOCATION".equals(wx.EventName.toUpperCase())) {
				wx.Latitude = xml.getRootElement().elementTextTrim("Latitude");
				wx.Longitude = xml.getRootElement().elementTextTrim("Longitude");
				wx.Precision = xml.getRootElement().elementTextTrim("Precision");
			} else {
				wx.EventKey = xml.getRootElement().elementTextTrim("EventKey");
			}
		}
		if ("text".equals(wx.MsgType.trim())) {
			wx.setContent(xml.getRootElement().elementTextTrim("Content"));
		}
		if ("location".equals(wx.MsgType.trim())) {
			wx.Location_X = xml.getRootElement().elementTextTrim("Location_X");
			wx.Location_Y = xml.getRootElement().elementTextTrim("Location_Y");
			wx.Scale = xml.getRootElement().elementTextTrim("Scale");
			wx.Label = xml.getRootElement().elementTextTrim("Label");

		}

		if ("voice".equals(wx.MsgType.trim())) {
			wx.Recognition = xml.getRootElement().elementTextTrim("Recognition");
		}

		return wx;
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

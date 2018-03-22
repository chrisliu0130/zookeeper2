package com.atguigu.mobile;

import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;

public class MainClient {

	public static void main(String[] args) {
		MobileCodeWSSoap mobileCodeWSSoap = new MobileCodeWS().getMobileCodeWSSoap();
		String codeInfo = mobileCodeWSSoap.getMobileCodeInfo("15164034851", "");
		System.out.println(codeInfo);
	}

}

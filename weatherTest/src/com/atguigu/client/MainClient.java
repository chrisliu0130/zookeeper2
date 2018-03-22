package com.atguigu.client;

import java.util.List;

import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class MainClient {

	public static void main(String[] args) {
		WeatherWSSoap weatherWSSoap = new WeatherWS().getWeatherWSSoap();
		List<String> weather = weatherWSSoap.getWeather("¥Û¡¨", "").getString();
		for (String string : weather) {
			System.out.println(string);
		}
	}

}

package com.atguigu.message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MainClient {

	@POST
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost("HTTP://192.168.19.105:9999/sms_test/sms");

		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();

		list.add(new BasicNameValuePair("phonenum", "15164034851"));
		list.add(new BasicNameValuePair("msg", "°×Ò¹×·Ð×2É¶Ê±ºòÉÏÓ³°¡£¿"));

		HttpEntity entityPost = new UrlEncodedFormEntity(list, "utf8");
		httpPost.setEntity(entityPost);

		HttpResponse response = httpClient.execute(httpPost);

		HttpEntity entity = response.getEntity();

		EntityUtils.consume(entity);
		httpClient.close();

	}

}

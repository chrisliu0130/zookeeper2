package com.atguigu.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.http.HttpStatus;

public class MainClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet httpGet = new HttpGet("...");

		HttpResponse httpResponse = httpClient.execute(httpGet);

		HttpEntity entity = httpResponse.getEntity();
		// 此处的entity是一个IO流
		// 如果没有得到httpResponse,也就得不到entity
		// 可以用状态码判断是否得到了httpResponse
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.OK_200) {
			EntityUtils.toString(entity);
		} else {
			System.err.println(httpResponse.getStatusLine().toString());
		}

		httpClient.close();
		EntityUtils.consume(entity);
	}

}

package com.soft2176.quickstart.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @program: java-web-dev
 * @description:
 * @author: ycshang
 * @create: 2022-02-24 21:55
 **/
public class MockHttp {
    public static void main(String[] args) throws Exception {
        URLConnection connection = new URL("http://localhost:9090/students").openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        //    设置请求方式
        httpURLConnection.setRequestMethod("GET");
        //    设置通用请求属性
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        //    建立实际连接
        connection.connect();
        //    获取响应头部，遍历输出
        Map<String, List<String>> map = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }
        //    获取响应状态码和响应消息
        int resCode = httpURLConnection.getResponseCode();
        String message = httpURLConnection.getResponseMessage();
        System.out.println("状态码" + resCode + ",响应消息" + message);
        //输出响应体
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder result = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            result.append("\n").append(inputLine);
        }
        System.out.println("result===" + result);
    }
}
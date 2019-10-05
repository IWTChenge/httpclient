package com.changshi.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import java.io.IOException;

public class TestHttpCient {

    public static void main(String[] args) {
        //doGetTestOne();
       // doGetTest2();
       // doPostone();
        doPost2();
    }

    /**
     * GET 无参
     */
    public static void doGetTestOne() {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://localhost:8080/httpclientgetnoparam");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * GET 有参
     */
    public static void doGetTest2() {
        CloseableHttpClient httpClient =HttpClientBuilder.create().build();
        //param
        StringBuffer params=new StringBuffer();
        params.append("name=hasParam");
        //创建Get请求
        HttpGet httpGet =new HttpGet("http://localhost:8080/httpclientgethasparam"+"?"+params);
        //响应模型
        CloseableHttpResponse closeableHttpResponse=null;
        RequestConfig requestConfig=RequestConfig.custom()
                //设置连接超时时间（ms）
                .setConnectTimeout(5000)
                //请求超时时间
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        //设置配置
        httpGet.setConfig(requestConfig);
        //执行请求
        try {
            closeableHttpResponse=httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = closeableHttpResponse.getEntity();
            System.out.println("响应状态为:" + closeableHttpResponse.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (closeableHttpResponse != null) {
                    closeableHttpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    /**
     * POST 无参
     */
    public static void doPostone() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://localhost:8080/httpclientpostnoparam");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    /**
     * POST 有参
     */
    public static void doPost2() {
        CloseableHttpClient httpClient =HttpClientBuilder.create().build();
        //param
        StringBuffer params=new StringBuffer();
        params.append("name=hasParam");
        //创建Get请求
        HttpPost httpPost =new HttpPost("http://localhost:8080/httpclientposthasparam"+"?"+params);
        //响应模型
        CloseableHttpResponse closeableHttpResponse=null;
        RequestConfig requestConfig=RequestConfig.custom()
                //设置连接超时时间（ms）
                .setConnectTimeout(5000)
                //请求超时时间
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        //设置配置
        httpPost.setConfig(requestConfig);
        //执行请求
        try {
            closeableHttpResponse=httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = closeableHttpResponse.getEntity();
            System.out.println("响应状态为:" + closeableHttpResponse.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (closeableHttpResponse != null) {
                    closeableHttpResponse.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

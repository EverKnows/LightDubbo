package com.hipac.Consumer;

import com.alibaba.fastjson.JSONObject;
import com.hipac.Framework.Invocation;
import com.hipac.Framework.URL;
import com.hipac.Registry.Impl.LocalRegistryImpl;
import com.hipac.Registry.LocalRegsitry;
import com.hipac.Registry.Registry;
import com.hipac.Service.QueryAPI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class consumer {
    public static LocalRegsitry cache = new LocalRegistryImpl();

    public static void main(String[] args) throws URISyntaxException {


        HttpClient client = HttpClientBuilder.create().build();
        List<URL> urlList = null;
        Registry.print();
        // Consumer 有本地缓存，先查询本地缓存，若本地缓存没有，则直接查询注册中心
        if (cache.getURL("QueryAPI") == null) {
            urlList = Registry.getURLList("QueryAPI");
            System.out.println(urlList);
            cache.cache("QueryAPI", urlList);
        } else {
            urlList = cache.getURL("QueryAPI");
        }
        //负载均衡算法
        URL url = LoadBalanceStrategy.loadBalance(urlList);

//        String urlStr = new StringBuilder().append(url.getHost()).append(":").append(url.getPort()).toString();
//        System.out.println(urlStr);
        URIBuilder uriBuilder = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080).setPath("").
                setParameter("Invocation", JSONObject.toJSONString(new Invocation(QueryAPI.class.getName(), "sayHello", null, null)));

        System.out.println(JSONObject.toJSONString(new Invocation(QueryAPI.class.getName(), "sayHello", null, null)));
        HttpGet get = new HttpGet(uriBuilder.build());

        try {
            HttpResponse res = client.execute(get);

            System.out.println("响应状态：" + res.getStatusLine());
            System.out.println("相应内容为" + EntityUtils.toString(res.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
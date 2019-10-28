package com.hipac.Producer;

import com.hipac.Framework.URL;
import com.hipac.Protocol.Http.HttpServer;
import com.hipac.Registry.Registry;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class producer {

    public static void main(String[] args) throws IOException {
        URL url = new URL("localhost", "8080");
        Registry.print();
        HttpServer.start("localhost", 8080);
        System.out.println("Provider");
        System.in.read();
    }
}
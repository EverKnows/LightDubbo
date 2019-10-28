package com.hipac.Registry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hipac.Framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class Registry {

    // URL 缓存
    private static HashMap<String, List<URL>> REGISTRY = Maps.newHashMap();
    static {
        List<URL> list = new ArrayList<URL>();
        list.add(new URL("localhost", "8080"));
        REGISTRY.put("QueryAPI", list);
    }
    public static void regist(String interfaceName, URL url) {
        if (null == REGISTRY.get(interfaceName)) {
            List<URL> urlList = Lists.newArrayList(url);
            REGISTRY.put(interfaceName, urlList);
        } else {
            REGISTRY.get(interfaceName).add(url);
        }
    }

    public static List<URL> getURLList(String interfaceName) {
        return REGISTRY.get(interfaceName);
    }



    public static void print() {
        System.out.println(REGISTRY.get("QueryAPI"));
    }
}
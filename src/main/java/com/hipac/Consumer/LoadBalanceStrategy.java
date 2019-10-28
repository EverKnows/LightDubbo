package com.hipac.Consumer;

import com.hipac.Framework.URL;

import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class LoadBalanceStrategy {
    public static URL loadBalance(List<URL> uriList) {

        int random = (int)Math.random()*1;
        System.out.println(random);
        return uriList.get(random);
    }

}
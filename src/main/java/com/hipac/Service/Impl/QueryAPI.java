package com.hipac.Service.Impl;

import java.io.Serializable;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class QueryAPI implements com.hipac.Service.QueryAPI, Serializable {

    private static final long serialVersionUID = 7542025314894613939L;

    public void sayHello() {
        System.out.println("Hello World");
    }
}
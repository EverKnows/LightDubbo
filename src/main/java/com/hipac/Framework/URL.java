package com.hipac.Framework;

import java.io.Serializable;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class URL implements Serializable {

    private static final long serialVersionUID = 4394500345220414015L;

    private String host;

    private String port;

    public URL(String host, String port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return host + ":" + port;
    }
}
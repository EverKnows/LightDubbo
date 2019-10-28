package com.hipac.Framework;

import java.io.Serializable;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class Invocation implements Serializable {

    private static final long serialVersionUID = 277161674745978113L;

    private String interfaceName;

    private String methodName;

    private Class[] params;

    private Object[] paramsType;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParams() {
        return params;
    }

    public void setParams(Class[] params) {
        this.params = params;
    }

    public Object[] getParamsType() {
        return paramsType;
    }

    public void setParamsType(Object[] paramsType) {
        this.paramsType = paramsType;
    }

    public Invocation(String interfaceName, String methodName, Class[] params, Object[] paramsType) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.params = params;
        this.paramsType = paramsType;
    }
}
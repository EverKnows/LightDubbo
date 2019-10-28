package com.hipac.Protocol.Http;

import com.alibaba.fastjson.JSONObject;
import com.hipac.Framework.Invocation;
import com.hipac.Service.Impl.QueryAPI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = -18527904456324818L;


    public static HashMap<String, Class> map = new HashMap<String, Class>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        try {
            System.out.println("Service is arrive");
            DispatcherServlet.Handle(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        map.put("com.hipac.Service.QueryAPI", QueryAPI.class);
        String parameter = req.getParameter("Invocation");

        Invocation invocation = JSONObject.parseObject(req.getParameter("Invocation"), Invocation.class);
        String interfaceName = invocation.getInterfaceName();
        System.out.println(interfaceName);
        Class clazz = map.get(interfaceName);
        QueryAPI instance = (QueryAPI)clazz.newInstance();
        instance.sayHello();
    }
}
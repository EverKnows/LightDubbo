package com.hipac.Protocol.Http;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;


/**
 * @author jianmiao.xu
 * @date 2019/10/26
 */
public class HttpServer {
    public static Tomcat tomcat = new Tomcat();

    public  static void start(String hostName, Integer port) {

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(port);

        StandardEngine engine = new StandardEngine();
        engine.setDefaultHost(hostName);

        StandardHost host = new StandardHost();
        host.setName(hostName);

        StandardContext context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet("", "DispatcherServlet", new DispatcherServlet());
        context.addServletMappingDecoded("/", "DispatcherServlet");
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }

}
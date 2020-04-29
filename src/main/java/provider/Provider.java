package provider;

import framework.URL;
import protocol.http.HttpServer;
import provider.api.HelloService;
import provider.impl.HelloServiceImpl;
import register.RemoteMapRegister;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 16:10
 * @Meaning:
 */

public class Provider {
    public static void main(String[] args) {
        // 1 本地注册
        //{服务名：实现类}
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);
        //2 远程注册
        //{服务名：List<URL>}
        URL url=new URL("localhost",8080);
        RemoteMapRegister.regist(HelloService.class.getName(),url);
        //3 启动Tomcat
        HttpServer httpServer=new HttpServer();
        httpServer.start("localhost",8080);
    }
}

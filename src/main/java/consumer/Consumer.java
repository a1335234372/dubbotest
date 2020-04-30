package consumer;

import framework.Invocation;
import framework.ProxyFactory;
import protocol.http.HttpClient;
import provider.api.HelloService;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:39
 * @Meaning:
 */

public class Consumer {
    public static void main(String[] args) {
        HelloService helloService= ProxyFactory.getProxy(HelloService.class);
        System.out.println("consumer:"+ helloService.sayHello("seele,good"));
    }
}

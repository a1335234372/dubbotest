package consumer;

import framework.Invocation;
import protocol.http.HttpClient;
import provider.api.HelloService;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:39
 * @Meaning:
 */

public class Consumer {
    public static void main(String[] args) {
        HttpClient httpClient=new HttpClient();
        Invocation invocation=new Invocation(HelloService.class.getName(),"sayHello",new Class[]{String.class},new Object[]{"Seele"});
        String result = httpClient.send("localhost",8080,invocation);
        System.out.println("consumer:"+result);
    }
}

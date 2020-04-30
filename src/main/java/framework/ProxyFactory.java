package framework;

import protocol.http.HttpClient;
import provider.api.HelloService;
import register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther Seele(pansong)
 * @date 2020/4/30 20:07
 * @Meaning:
 */
// 代理对象
public class ProxyFactory {
    public static <T> T getProxy( Class interfaceClass){
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HttpClient httpClient=new HttpClient();
                Invocation invocation=new Invocation(interfaceClass.getName(),method.getName(),method.getParameterTypes(),args);
                URL url = RemoteMapRegister.random(interfaceClass.getName());
                String result = httpClient.send(url.getHostname(),url.getPort(),invocation);
                return result;
            }
        });
    }
}

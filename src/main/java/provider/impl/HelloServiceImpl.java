package provider.impl;

import provider.api.HelloService;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 16:08
 * @Meaning:
 */

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }
}

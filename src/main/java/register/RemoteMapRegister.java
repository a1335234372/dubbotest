package register;

import framework.URL;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:27
 * @Meaning:
 */

public class RemoteMapRegister {
    private  static Map<String,List<URL>> REGISTER=new HashMap<>();

    public static void regist(String interfaceName, URL url){
        List<URL> list= Collections.singletonList(url);
        REGISTER.put(interfaceName,list);
    }



}

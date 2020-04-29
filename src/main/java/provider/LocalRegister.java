package provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:22
 * @Meaning:
 */

public class LocalRegister {

    private  static Map<String,Class> map=new HashMap<>();

    public static void regist(String interfaceName,Class implClass){
        map.put(interfaceName,implClass);
    }

    public static Class get(String interfaceName){
        return map.get(interfaceName);
    }
}

package register;

import framework.URL;

import java.io.*;
import java.util.*;

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
        saveFile();
    }
    // 模拟负载均衡  传进来一个调用的服务名  返回对应服务的URL
    public static URL random(String interfaceName){
        REGISTER=getFile();
        List<URL> list=REGISTER.get(interfaceName);
        Random random=new Random();
        int n =random.nextInt(list.size());
        return list.get(n);
    }

    public static void saveFile(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String,List<URL>> getFile(){
        try  {
            FileInputStream fileInputStream = new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            return (Map<String,List<URL>>) objectInputStream.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 16:29
 * @Meaning:
 */

public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        //  处理请求 返回数据
        try  {
            InputStream ips = req.getInputStream();
            ObjectInputStream ois=new ObjectInputStream(ips);
            Invocation invocation= (Invocation) ois.readObject();
            //获取接口类
            Class implClass= LocalRegister.get(invocation.getInterfaceName());
            // 获取接口的方法
            Method method= implClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());
            //执行方法
            String result= (String) method.invoke(implClass.newInstance(),invocation.getParams());
            // 返回数据
            IOUtils.write(result,resp.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

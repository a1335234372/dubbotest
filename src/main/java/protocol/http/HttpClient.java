package protocol.http;

import framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:40
 * @Meaning:
 */

public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation){
        try{
            URL url=new URL("http",hostname,port,"/");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            // 发送数据  使用outputStream
            OutputStream ops= httpURLConnection.getOutputStream();
            ObjectOutputStream  oos=new ObjectOutputStream(ops);

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream inputStream=httpURLConnection.getInputStream();
            String result= IOUtils.toString(inputStream);
            return result;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

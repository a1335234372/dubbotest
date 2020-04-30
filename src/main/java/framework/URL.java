package framework;

import java.io.Serializable;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:29
 * @Meaning:
 */

public class URL implements Serializable{

    private String hostname ;

    private Integer port;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}

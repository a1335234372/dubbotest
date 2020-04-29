package framework;

import java.io.Serializable;

/**
 * @auther Seele(pansong)
 * @date 2020/4/29 18:45
 * @Meaning:
 */

public class Invocation implements Serializable {

    private String interfaceName;//接口名
    private  String methodName;//方法名
    private  Class[] paramTypes;// 方法的参数列表
    private  Object[] params; //方法的参数

    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

}

package wzq.test.proxy.dynamiccproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//继承调用处理器类
public class DynamicProxyHandler implements InvocationHandler {
    // 保存一个委托类的对象
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    // 三个参数：代理类的引用，方法名和方法的参数列表
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        // 实现对委托类方法的调用，参数表示委托类对象和参数
        return method.invoke(proxied, args);
    }
}
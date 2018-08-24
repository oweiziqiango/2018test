package wzq.test.proxy.dynamiccproxy;

import java.lang.reflect.Proxy;

import wzq.test.proxy.staticproxy.Interface;
import wzq.test.proxy.staticproxy.RealObject;//委托类
/**
 * 静态代理的局限性在于，代理类需要在程序运行之前就编写好，而动态代理则可以在程序运行的过程中动态创建并处理对所代理方法的调用。
 * 
 * 在动态代理中，需要定义一个中介类，这个类实现InvocationHandle接口（主要是里面的invoke方法）。
 * 这个中介类位于委托类和代理类之间，作为一个调用处理器而存在。
 * 它保存一个委托类的引用，通过传入委托类对象进行初始化；
 * 然后在invoke方法中，实现对委托类方法的调用，并增加需要的额外操作。
 * 
 * 在需要使用动态代理时，首先通过Proxy类中的newProxyInstance方法得到代理类对象
 * （方法的三个参数分别是：
 * （通常是委托类实现接口的）类加载器，希望代理类实现的接口列表（通常也是委托类实现的接口），以及一个调用处理器的对象），
 *  然后通过这个代理类对象直接调用代理类的方法。
 * 这种调用实际上会通过调用处理器调用invoke方法，进而实现对委托类相应方法的调用。
	
	注意在动态代理中，只实现了一个调用处理器，而没有真正实现代理类。
	代理类对象是通过Proxy类中的newProxyInstance方法得到的。
	这样，不管你在调用委托类任何方法时需要加入的额外操作，都可以仅仅在调用处理器中的invoke方法中实现就可以了。
	代码示例如下（来自Java编程思想）：
 * @author Administrator
 *
 */
public class SimpleDynamiProxyDemo {
	public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // 通过Proxy.newProxyInstance方法得到  代理类对象
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[] { Interface.class }, new DynamicProxyHandler(real));
        // 通过代理类对象直接调用方法，会被重定向到调用处理器上的invoke方法
        consumer(proxy);
    }
}

package wzq.test.proxy.staticproxy;
/**
 * 
 * 静态代理。简单来说，代理就是用一个代理类来封装一个委托类，
 * 这样做有两个好处：可以隐藏委托类的具体实现；可以在不改变委托类的情况下增加额外的操作。
 * 而静态代理，就是在程序运行之前，代理类就已经存在了。
 * 静态代理一般的实现方式为：委托类和代理类都实现同一个接口或者是继承自同一个父类，
 * 然后在代理类中保存一个委托类的对象引用（父类或者父类接口的对象引用），
 * 通过给构造器传入委托类的对象进行初始化，在同名方法中通过调用委托类的方法实现静态代理。
 * 除此之外，在代理类同名方法中还可以实现一些额外的功能。
 * 代码示例如下（借用Java编程思想中的实例），RealObject类为委托类，SimpleProxy类为代理类：
 * @author Administrator
 *
 */
public class SimpleProxyDemo {
	 public static void main(String[] args) {
        consumer(new RealObject());
        //consumer（代理类（委托类））
        consumer(new SimpleProxy(new RealObject()));
	 }

    public static void consumer(Interface iface) {
	    iface.doSomething();
	    iface.somethingElse("bonobo");
    }
}	

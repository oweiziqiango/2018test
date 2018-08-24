package wzq.test.proxy.staticproxy;

public class SimpleProxy implements Interface {
    // 保存委托类（父接口的引用）
    private Interface proxied;

    // 传入委托类的对象用于初始化
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    // 两个同名方法中还实现了其他的功能
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

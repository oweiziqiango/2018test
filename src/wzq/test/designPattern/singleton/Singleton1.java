package wzq.test.designPattern.singleton;

/*
 * 懒汉式  非线程安全的
 * 在用户第一次调用时初始化
 * 而且在第一次加载时需要实例化
 * 「懒汉式」与「饿汉式」的最大区别就是将单例的初始化操作，延迟到需要的时候才进行
 */
public class Singleton1 {
	private static Singleton1 instance;
	
	private Singleton1(){
		System.out.println("懒汉式");
	}
	
	public static Singleton1 getInstance(){
		if(instance==null){
			instance = new Singleton1();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton1 s = getInstance();
	}
}

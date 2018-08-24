package wzq.test.designPattern.singleton;
/**
 * 单例模式
 * 	定义：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * https://itimetraveler.github.io/2016/09/08/%E3%80%90Java%E3%80%91%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%9A%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F/
 */
/*
 *静态内部类
 *
 *第一次加载Singleton类时并不会初始化  instance，
 *只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，
 *这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
 */
public class Singleton4 {
	//private static Singleton4 instance;
	
	private Singleton4(){
		System.out.println("静态内部类");
	}
	
	public static Singleton4 getInstance(){
		//提供一个访问它的全局访问点。
		return Singleton4Holder.instance;
	}
	//静态内部类
	private static class Singleton4Holder{
		private static final Singleton4 instance = new Singleton4();
	}
	
	public static void main(String[] args) {
		
	}

}

package wzq.test.designPattern.singleton;
/**
 * 单例模式
 * 	定义：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * https://itimetraveler.github.io/2016/09/08/%E3%80%90Java%E3%80%91%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%9A%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F/
 */
/*
 * 双重校验锁模式
 * 「双重校验锁」：既可以达到线程安全，也可以使性能不受很大的影响，
 * 换句话说在保证线程安全的前提下，既节省空间也节省了时间，
 * 集合了「饿汉式」和两种「懒汉式」的优点，取其精华，去其槽粕。
 */
public class Singleton3 {
	/**
     * 注意此处使用的关键字 volatile，
     * 被volatile修饰的变量的值，将不会被本地线程缓存，
     * 所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量。
     */
	private volatile static Singleton3 instance;
	
	private Singleton3(){
		System.out.println("双重校验锁（DCL）");
	}
	
	public static Singleton3 getInstance(){
		/*
		 * 第一次是为了不必要的同步，
		 * 第二次是在singleton等于null的情况下才创建实例。
		 */
		if(instance == null){
			synchronized(Singleton3.class){
				if(instance == null){
					instance = new Singleton3();
				}
			}
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		
	}

}

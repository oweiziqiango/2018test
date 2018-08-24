package wzq.test.designPattern.singleton;
/**
 * 单例模式
 * 	定义：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * https://itimetraveler.github.io/2016/09/08/%E3%80%90Java%E3%80%91%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%9A%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F/
 */
/*
 * 饿汉式
 * 在类装载的时候就创建，不管你用不用，先创建了再说，
 * 如果一直没有被使用，便浪费了空间，典型的空间换时间，每次调用的时候，
 * 就不需要再判断，节省了运行时间
 */
public class Singleton0 {
	private static Singleton0 instance = new Singleton0();
	
	private Singleton0(){
		System.out.println("饿汉式");
	}
	
	public static Singleton0 getInstance(){
		return instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Singleton0 s0 = getInstance();
		//Singleton0 s1 = getInstance();
		//System.out.println("s0:"+s0);
		//System.out.println("s1:"+s1);
	}

}

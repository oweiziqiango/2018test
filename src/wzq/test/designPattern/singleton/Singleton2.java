package wzq.test.designPattern.singleton;

/*
 * 懒汉式  线程安全的
 */
public class Singleton2 {
	
	private static Singleton2 instance;
	
	private Singleton2(){
		System.out.println("线程安全的懒汉式");
	}
	
	public static synchronized  Singleton2 getInstance(){
		if(instance==null){
			instance = new Singleton2();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		
	}
}

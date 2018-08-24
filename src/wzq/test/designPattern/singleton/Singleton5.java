package wzq.test.designPattern.singleton;
/**
 * 单例模式
 * 	定义：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * https://itimetraveler.github.io/2016/09/08/%E3%80%90Java%E3%80%91%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%9A%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F/
 */
/*
 * 枚举
 * 使用枚举来实现单实例控制会更加简洁，而且无偿地提供了序列化机制，
 * 并由JVM从根本上提供保障，绝对防止多次实例化，是更简洁、高效、安全的实现单例的方式。
 * 
 * 枚举单例的优点就是简单，但是大部分应用开发很少用枚举，可读性并不是很高，不建议用。
 */
public enum Singleton5 {
	//INSTANCE;
	instance;
	private Singleton5(){
		
	}
	public void doSomething(){
		System.out.println("doSomething");
	}
	
	public static void main(String[] args) {
		Singleton5 s = Singleton5.instance;
		s.doSomething();
	}

}

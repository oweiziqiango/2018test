package wzq.test.designPattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式
 * 	定义：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * https://itimetraveler.github.io/2016/09/08/%E3%80%90Java%E3%80%91%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%EF%BC%9A%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F/
 */
/*
 * 使用容器
 * 
 * 这种是用SingletonManager 将多种单例类统一管理，
 * 在使用时根据key获取对象对应类型的对象。
 * 这种方式使得我们可以管理多种类型的单例，并且在使用时可以通过统一的接口进行获取操作，
 * 降低了用户的使用成本，也对用户隐藏了具体实现，降低了耦合度。
 */
public class SingletonManager {
	private static Map<String, Object> objMap = new HashMap<>();
	
	private SingletonManager(){
		System.out.println("使用容器");
	}
	
	public static void registerService(String key,Object instance){
		if(!objMap.containsKey(key)){
			objMap.put(key, instance);
		}
	}
	
	public static Object getService(String key){
		return objMap.get(key);
	}
	
	public static void main(String[] args) {
		
	}

}

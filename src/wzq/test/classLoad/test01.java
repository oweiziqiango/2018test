package wzq.test.classLoad;
class SuperClass{
	static{
		System.out.println("SuperClass init");
	}
	public static int value = 123;
}
class SubClass extends SuperClass{
	static{
		System.out.println("SubClass init");
	}
}

public class test01 {
	public static void main(String[] args) {
		/*
		 * 通过子类调用父类的静态字段，不会导致子类初始化
		 */
		//System.out.println(SubClass.value);
		
		/*
		 * 通过数组定义来引用类，不会触发此类的初始化
		 */
		SuperClass[] supers = new SuperClass[10];
	}
}

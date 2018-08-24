package wzq.test.classLoad;

class ConstClass{
	static{
		System.out.println("ConstClass init!");
	}
	public static final String HELLOWORD = "hello world";
}
public class test02 {
	public static void main(String[] args) {
		/*
		 * 常量在编译阶段 会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
		 */
		System.out.println(ConstClass.HELLOWORD);
	}
}

package wzq.test.classLoad;



public class test04 {
	/*static {
		i = 0;//可以在赋值，但不能访问
		//System.out.println(i);//非法向前引用
	}
	static int i = 1;*/
	
	static class Parent{
		public static int A = 1;
		static{
			A = 2;
		}
	}
	static class Sub extends Parent{
		public static int B = A;
	}
	public static void main(String[] args) {
		System.out.println(Sub.B);
	}
}

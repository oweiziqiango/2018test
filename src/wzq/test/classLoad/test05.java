package wzq.test.classLoad;

public class test05 {
	/*
	 * 虚拟机会保证一个类的<clinit>()方法 在多线程的情况下正确地加锁同步
	 * 如果多个线程去访问一个类，只会有一个线程去执行这个类的<clinit>()方法
	 * 其他线程都需要阻塞等待，知道活动线程执行<clinit>()方法完毕
	 */
	static class DeadLoopClass{
		static{
			if(true){
				System.out.println(Thread.currentThread().getName()+"init DeadLoopClass");
				while(true){
					
				}
			}
		}
	}
	public static void main(String[] args){
		Runnable script = new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName()+"start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread().getName()+"end");
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}

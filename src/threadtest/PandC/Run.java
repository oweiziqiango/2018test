package threadtest.PandC;

public class Run {
	/*
	 *一个生产者
	 *多个消费者
	 *
	 * 消费者运行notify唤醒的不一定是生产者  一旦唤醒的仍然是消费者  就会出现假死状态  所有线程都在等待 共享变量被改变
	 * 
	 * 多个生产者 和 多个消费者  一样
	 * 
	 * 所以将notify() 改为 notifyAll()
	 * 程序才会继续一直运行
	 */
	public static void main(String[] args) throws Throwable {
		MyStack mystack = new MyStack();
		P p1 = new P(mystack);
		P p2= new P(mystack);
		P p3 = new P(mystack);
		P p4 = new P(mystack);
		P p5 = new P(mystack);
		C r1 = new C(mystack);
		C r2 = new C(mystack);
		C r3 = new C(mystack);
		C r4 = new C(mystack);
		C r5 = new C(mystack);
		
		P_Thread pThread1 = new P_Thread(p1);
		P_Thread pThread2 = new P_Thread(p2);
		P_Thread pThread3 = new P_Thread(p3);
		P_Thread pThread4 = new P_Thread(p4);
		P_Thread pThread5 = new P_Thread(p5);
	
		pThread1.start();
		pThread2.start();
		pThread3.start();
		pThread4.start();	
		pThread5.start();
		
		Thread.sleep(100);
		
		C_Thread c1 = new C_Thread(r1);
		C_Thread c2 = new C_Thread(r2);
		C_Thread c3 = new C_Thread(r3);
		C_Thread c4 = new C_Thread(r4);
		C_Thread c5 = new C_Thread(r5);
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}
		
}

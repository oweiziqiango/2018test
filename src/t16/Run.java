package t16;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		RunThread thread = new RunThread();
		thread.start();
		Thread.sleep(1000);
		//线程调用 赋值方法 修改的是公共变量  线程的私有变量仍然是true
		thread.setRunning(false);
		System.out.println("已经赋值为false");
	}
}

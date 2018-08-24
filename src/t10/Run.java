package t10;

public class Run {
	/*
	 * 使用线程在非server模式下 
	 *  可以解决中断 调用方法中的死循环
	 *  
	 *  什么时候读取共享内存中的变量
	 *  什么时候只读取私有内存中的变量    server模式下 
	 */
	public static void main(String[] args) throws InterruptedException {
		PrintString printString = new PrintString();
		//printString.printStringMethod();
		new Thread(printString).start();
		System.out.println("我要停止它！stopThread=" + 
				Thread.currentThread().getName());
		Thread.sleep(1000);
		//不是线程调用  修改   私有堆栈中的变量
		printString.setContinuePrint(false);
	}
}

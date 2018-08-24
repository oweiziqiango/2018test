package t99;

public class Run {
	/*
	 * 没有线程，使用中断不了  调用方法中的循环
	 * 使用t10中的方式  多线程解决死循环
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		PrintString printString = new PrintString();
		printString.printStringMethod();
		
		System.out.println("我要停止它！stopThread=" + 
		Thread.currentThread().getName());
		
		printString.setContinuePrint(false);
		
	}
}

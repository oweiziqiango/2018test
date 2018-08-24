package t10;

public class PrintString implements Runnable{
	private boolean isContinuePrint = true;
	public boolean isContinuePrint(){
		return isContinuePrint;
	}
	
	public void setContinuePrint(boolean isContinuePrint){
		this.isContinuePrint = isContinuePrint;
	}
	
	public void printStringMethod() throws InterruptedException{
		while(isContinuePrint == true){
			System.out.println("run printStringMethod threadName ="
		+Thread.currentThread().getName());
			Thread.sleep(1000);
		}
	}
	
	public void run() {
		try {
			printStringMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

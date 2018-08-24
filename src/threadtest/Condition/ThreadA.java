package threadtest.Condition;

public class ThreadA extends Thread{
	private MyService service;
	ThreadA(MyService service){
		this.service = service;
	}
	@Override
	public void run() {
		for(int i  = 0 ;i<Integer.MAX_VALUE;i++ )
			service.set();
	}
}

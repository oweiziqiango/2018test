package threadtest.Condition;

public class Run {
	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadA[] myThreadA = new ThreadA[10];
		ThreadB[] myThreadB = new ThreadB[10];
		
		for(int i=0;i<10;i++){
			myThreadA[i] = new ThreadA(service);
			myThreadB[i] = new ThreadB(service);
			myThreadA[i].start();
			myThreadB[i].start();
		}
	}
}

package threadtest.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5 {
	static class MyTask extends TimerTask{
		public void run() {
			try {
				System.out.println("begin "+ System.currentTimeMillis());
			
				Thread.sleep(1000);
				
				System.out.println("end "+ System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			
			MyTask myTask = new MyTask();
			Timer timer = new Timer();
			//timer.schedule(myTask, date,3000);
			timer.scheduleAtFixedRate(myTask, date, 3000);
		}
	}
	
}

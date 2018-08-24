package threadtest.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class Test9 {
	static class MyTask extends TimerTask{
		public void run() {
				System.out.println("begin "+ System.currentTimeMillis());
				System.out.println("end "+ System.currentTimeMillis());
			}
		}
		public static void main(String[] args) {
			
			Calendar calendar = Calendar.getInstance();
			//设置计划执行时间
			calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)-20);
			Date date = calendar.getTime();
			
			MyTask myTask = new MyTask();
			Timer timer = new Timer();
			//timer.schedule(myTask, date,3000);
			//scheduleAtFiedRate具有追赶性   即计划执行时间早于当前时间，会“补充性”执行两个时间段内所对应的Task任务
			timer.scheduleAtFixedRate(myTask, date, 5000);
		}
}

package threadtest.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hashValue = false;
	public void set(){//生产
		try {
			lock.lock();
		while(hashValue == true){
			System.out.println("有可能连续..");
			condition.await();
		}
		System.out.println("打印.");
		hashValue = true;
		//condition.signal();
		condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	
	public void get(){//消费
		try {
			lock.lock();
		while(hashValue == false){
			System.out.println("有可能连续。。");
			condition.await();
		}
		System.out.println("打印。");
		hashValue = false;
		//condition.signal();
		condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}

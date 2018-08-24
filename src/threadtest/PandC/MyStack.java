package threadtest.PandC;

import java.util.ArrayList;

public class MyStack {
	//共享变量
	private ArrayList<String> list = new ArrayList<String>();
	
	synchronized public void push(){
		try {
			while(list.size()==1){
				this.wait();
			}
			list.add("angString="+Math.random());
			//this.notify();
			this.notifyAll();
			System.out.println("push="+list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized public String pop(){
		String returnValue= "";
		try {
			while(list.size()==0){
				System.out.println("pop中"+Thread.currentThread().getName()+"waiting 了");
				this.wait();
			} 
			returnValue = (String) list.get(0);
			list.remove(0);
			//this.notify();
			this.notifyAll();
			System.out.println("pop="+list.size());
		}catch (InterruptedException e) {
				e.printStackTrace();
		}
		return returnValue;
	}
}

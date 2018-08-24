package threadtest.PandC;
/**
 * 生产者
 * @author Administrator
 *
 */
public class P {
	private MyStack mystack;
	public P(MyStack mystack){
		this.mystack = mystack;
	}
	public void pushService(){
		mystack.push();
	}
}

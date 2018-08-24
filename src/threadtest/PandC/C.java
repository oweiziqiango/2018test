package threadtest.PandC;
/**
 * 消费者
 * @author Administrator
 *
 */
public class C {
	private MyStack mystack;
	public C(MyStack mystack){
		this.mystack = mystack;
	}
	
	public void popService(){
		mystack.pop();
	}

}

package wzq.test.gc;

public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;
	
	public void isAlive(){
		System.out.println("yes , i am still alive :");
	}
	protected void finalize()throws Throwable{
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new FinalizeEscapeGC();
		//第一次拯救了自己
		SAVE_HOOK = null;
		System.gc();
		//finalize()低优先级 等它运行
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead : (");
		}
		
		//第二次因为已经执行过finalize(),所以被标记为 ：“没有必要执行”
		SAVE_HOOK = null;
		System.gc();
		
		Thread.sleep(500);
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead : (");
		}
	}
}

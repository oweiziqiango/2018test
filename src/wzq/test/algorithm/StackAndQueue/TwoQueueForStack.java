package wzq.test.algorithm.StackAndQueue;
import java.util.LinkedList;
import java.util.Queue;
public class TwoQueueForStack<E> {
	
	/*
	 * 使用两个队列实现栈  栈的特点是先进后出，后进先出
	 * 思路：两个Queue 使用LinkedList实例化  LinkedList实际上是一个双向链表
	 * 		q1作为入栈的队列  即直接将入栈的数据放入q1
	 * 		q2作为出栈的队列  即需要出栈时，如果q1只有一个元素 直接出栈
	 * 		如果q1不止一个元素，即可以将q1队列中的数据依次放入q2，最后一个不放入，最后一个元素输出
	 * 		再将q2中的元素依次放回q1
	 */
	private Queue<E> q1 = new LinkedList<E>();
	private Queue<E> q2 = new LinkedList<E>();;
	public static void main(String[] args) {
		TwoQueueForStack<Integer> stack = new TwoQueueForStack<>();
		stack.put(1);
		stack.put(2);
		stack.put(3);
		while(!stack.empty()){
			int i = stack.pop();
			System.out.println(i);
		}

	}
	
	//判断是否栈空
		public boolean empty(){
			return q1.isEmpty() && q2.isEmpty();
		}
		
		//出栈
		public synchronized E pop(){
			int size = q1.size();
			if(size==1)
				return q1.poll();
			
			int i=1;
			while(!(i==size)){
				q2.add(q1.poll());
				i++;
			}
			E e = q1.poll();
			
			while(!q2.isEmpty()){
				q1.add(q2.poll());
			}
			return e;
		}
		//入栈
		public synchronized void put(E e){
			q1.add(e);
		}

}

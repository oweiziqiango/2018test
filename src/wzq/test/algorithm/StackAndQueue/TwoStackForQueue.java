package wzq.test.algorithm.StackAndQueue;

import java.util.Stack;

public class TwoStackForQueue<E> {

	/*
	 * 用法两个stack 实现队列操作   队列是先进先出的
	 * 思想：设置两个stack A,B， stackA为入队的栈，stackB为出队的栈
	 * 		入队直接进栈A，出栈需要判断栈B是否为空，如果为空，需要将栈A中的元素放入栈B中
	 * 		如果不为空 直接获取栈B的栈顶元素
	 */
	Stack<E> A = new Stack<>();
	Stack<E> B = new Stack<>();
	public static void main(String[] args) {
		TwoStackForQueue<Integer> queue = new TwoStackForQueue<>();
		queue.put(1);
		queue.put(2);
		queue.put(3);
//		int i = queue.pop();
//		System.out.println(i);
//		i = queue.pop();
//		System.out.println(i);
//		i = queue.pop();
//		System.out.println(i);
		while(!queue.empty()){
			int i = queue.pop();
			System.out.println(i);
		}
		
	}
	//判断是否队空
	public boolean empty(){
		return A.isEmpty() && B.isEmpty();
	}
	
	//出队
	public synchronized E pop(){
		/*if(B.isEmpty()){
			if(A.isEmpty())
				return null;
			while(!A.isEmpty())
			{
				B.push(A.pop());
			}
			return B.pop();
		}
		return B.pop();*/
		//优化
		if(B.isEmpty()){
			while(!A.isEmpty())
			{
				B.push(A.pop());
			}
		}
		return B.pop();
	}
	//入队
	public synchronized void put(E e){
		A.push(e);
	}
	
	
	

}

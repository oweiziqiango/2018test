package wzq.test.algorithm.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyQueue<E> {
	/*
	 * 使用（list）实现队列 先进先出 后进后出
	 * 思路使用LinkedList  本质是双向链表
	 * 入队 链表后插入
	 * 出队 获取链表头部元素 并remove掉
	 */
	private LinkedList<E> list = new LinkedList<E>();
	private int size ;
	public synchronized void push(E e){
		list.add(e);
		//list.addLast(e);
		size++;
	}
	public synchronized E pop(){
		E e = list.removeFirst();
		size--;
		return e;
	}
	
	public synchronized boolean empty(){
		return size==0;
	}
	
	public synchronized int size(){
		return size;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList arrray = new ArrayList();
		ArrayList<Integer> list = new ArrayList<>();
		MyQueue<Integer> mq = new MyQueue<>();
		mq.push(4);//
		mq.push(2);
		
		System.out.println(mq.size);
		System.out.println(mq.pop());
		System.out.println(mq.size);
		//使用链表实现队列
//		Queue<Integer> q = new Queue();
//		q.push(1);
//		q.push(2);
//		q.push(3);
//		System.out.println(q.size());
//		System.out.println(q.pop());
//		System.out.println(q.pop());
//		System.out.println(q.peek());
	}

}
/*
 * 使用链表实现队列  先进先出
 * 思路：使用单向链表 就可以
 * 		先设定head 和 tail 相当于队头和队尾
 * 		入队时，相当于后插法，后进队的元素用队尾的指针添加进链表中
 * 		出栈时，获取head队头元素，然后去掉head （head= head.next）
 */
class Queue<E>{
	Node<E> head = null;
	Node<E> tail = null;
	//判读是否队空
	public boolean isEmpty(){
		if(head == null && tail==null){
			return true;
		}
		else
			return false;
	}
	//读队头
	public E peek(){
		if(isEmpty())
			return null;
		return head.data;
	}
	//从队头 出队
	public E pop(){
		if(isEmpty())
			return null;
		E e = head.data;
		head= head.next;
		return e;
	}
	//进队尾
	public void push(E data){
		Node<E>  newNode = new Node<E>(data);
		if(head==null && tail == null)
		{
			head = newNode;
			tail = newNode; 
		}else{
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	//队长
	public int size(){
		if(head == null)
			return 0;
		int len = 1 ;
		Node<E> l = head;
		while(l.next!=null){
			len++;
			l = l.next;
		}
		return len;
	}
}
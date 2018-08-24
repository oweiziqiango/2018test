package wzq.test.algorithm.StackAndQueue;

import java.util.Arrays;

public class MyStack<E> {

	/*
	 * 用数组实现栈  先进后出，后进先出
	 * 思路：定义一个数组，用来保存入栈的数据，数组初始化大小为10
	 *     用size表示入栈数据的个数 而size-1则是对应的数组下标
	 *     （由于是数组，需要考虑扩容的问题）
	 *     入栈时，需要判断数据个数是否超出数组大小，如果超出 使用Arrays.copyOf(,)来扩容
	 *     
	 *     出栈时，则直接获取栈顶数据，即根据size-1获取后进的数据元素的数组下标，然后将对应出栈
	 *     的数据元素的数组下标处置空。
	 *     
	 */
	private Object[] stack;
	private int size; //初始化为0
	public MyStack(){
		stack = new Object[10];
	}
	//判读是否栈为空
	public boolean isEmpty(){
		return size==0;
	}
	//查看堆栈顶部的对象，而不将其从堆栈中移除。
	@SuppressWarnings("unchecked")
	public E peek(){
		if(isEmpty())
		{
			return null;
		}
		return (E)stack[size-1];
	}
	//栈顶元素 出栈
	public E pop(){
		E e = peek();
		stack[size-1]=null;
		size--;
		return e;
	}
	
	//入栈
	public E push(E item){
		ensureCapacity(size+1);
		stack[size++] = item;
		return item;
	}
	//
	private void ensureCapacity(int size) {
		int len = stack.length;
		if(size>len)
		{	
			int newLen = 10;
			//copy stack to newLen+len of length ’s array
			stack = Arrays.copyOf(stack, newLen+len);
		}	
	}

	public static void main(String[] args) {
//		MyStack<Integer> ms = new MyStack<>();
//		System.out.println(ms.size);
//		ms.push(1);
//		ms.push(2);
//		ms.push(1);
//		ms.push(2);
//		ms.push(1);
//		ms.push(2);
//		ms.push(1);
//		ms.push(2);
//		ms.push(1);
//		ms.push(2);
//		ms.push(1);
//		ms.push(2);
//		System.out.println(ms.size);
//		System.out.println("栈顶元素："+ms.pop());
//		System.out.println("栈顶元素："+ms.pop());
		
		//链表实现栈
		Stack<Integer> stack = new Stack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		//System.out.println(stack.pop());
		System.out.println(stack.peek());
	}
	

}


/*
 * 使用链表实现栈  先进后出  后进先出
 * 思路： 栈顶位置top  根据链表 进行前插法 将入栈的元素放在链表头部
 *      出栈的时候，就直接可以从链表头部取出
 */
class Node<E>{
	Node<E> next = null;
	E data;
	Node(E data){
		this.data = data;
	}
}
class Stack<E>{
	Node<E> top = null;
	
	//判读是否栈空
	public boolean isEmpty(){
		return top==null;
	}
	//读栈顶元素
	public E peek(){
		if(isEmpty()){
			return null;
		}
		return top.data;
	}
	
	//取出栈顶元素
	public E pop(){
		if(isEmpty()){
			return null;
		}
		E data = top.data;
		top = top.next;
		return data;
	}
	
	
	
	//元素入栈
	public void push(E data){
		Node<E> newNode = new Node<E>(data);
		newNode.next = top;
		top = newNode;
	}
}

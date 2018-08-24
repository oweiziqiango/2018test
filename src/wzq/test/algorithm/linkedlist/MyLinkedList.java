package wzq.test.algorithm.linkedlist;

public class MyLinkedList {
	Node head = null;
	
	public static void main(String[] args) {
		MyLinkedList link = new MyLinkedList();
		link.addLinkedList(3);
		link.addLinkedList(1);
		link.addLinkedList(5);
		link.addLinkedList(3);
		link.addLinkedList(2);
		link.print();
		System.out.println();
		//在不知道结点头部 删除指定结点
		link.deleteLinkNode(link.findKPost(2));
		link.print();
		//反转单链表
		//link.ReverseLink(link.head);
		//link.print();
		//设置环
		/*Node z =link.findKPost(1);
		Node r = link.findKPost(3);
		if(z.next==null)
			z.next = r;*/
		//判断两条单向链表是否相交
		//boolean b = link.isIntersect(link.head, r);
		//System.out.println(b);
		//找到第一次相交的节点
		//Node f = link.getFirstMeetNode(link.head, r);
		//System.out.println("相交的节点值是："+f.data);
		//判断链表中是否有环
		/*boolean b1 = link.isLoop(link.head);
		System.out.println(b1);
		*/
		//找到环入口
	/*	Node r0 = link.isLoopNode(link.head);
		if(r0!=null)
			System.out.println("环入口值为："+r0.data);*/
		
		//删除第index个元素
		//link.deleteLinkedList(4);
		//link.print();
		
		//找到倒数第k个元素
		//Node  k =link.findKPost(3);
		//System.out.println(k.data);
		//删除重复数据
		//link.deleteRepeat();
		//link.print();
		//输出链表的长度
		//System.out.println("length :"+link.getLength());
		//从尾到头输出链表
		//link.postPrint(link.head);
		
		//寻找单链表中的中间节点
		//Node mid = link.findMidNode();
		//System.out.println(mid.data);
		//从小到大排序
		//link.sortLinkedList();
		//link.print();

	}
	public boolean deleteLinkNode(Node n) {
		// TODO Auto-generated method stub
		if(n==null || n.next == null){
			return false;
		}
		Node nextNode = n.next;
		n.data = nextNode.data;
		n.next = nextNode.next;
		return true;
	}
	//反转链表
	public void ReverseLink(Node head){
		//Node isRevereLink = null;
		Node pNode = head;
		Node pPrev = null;//倒序链表的头部
		while(pNode!=null){
			Node pNext = pNode.next;
			/*if(pNext!=null){
				isRevereLink = pNext;
			}*/
			pNode.next = pPrev;//从正序链表上截取一个结点 ，前插法放入倒序中
			pPrev = pNode;// 指向倒序链表的头部
			pNode = pNext;//正序链表中剩余部分
		}
		this.head = pPrev;
	}
	
	//如果两个链表相交，找到相交的节点
	public Node getFirstMeetNode(Node h1,Node h2){
		if(h1==null || h2 == null)
			return null;
		//遍历得到链表1的长度
		int len1 = 1;
		Node tail1 = h1;
		while(tail1.next!=null){
			len1++;
			tail1=tail1.next;
		}
		
		//遍历得到链表2的长度
		int len2 = 1;
		Node tail2 = h2;
		while(tail2.next!=null){
			len2++;
			tail2=tail2.next;
		}
		//判断哪个链表更长，长几个结点，然后长的链表先遍历几个结点
		Node t1 = h1;
		Node t2 = h2;
		if(len1>len2){
			int i = len1-len2;
			while(i!=0){
				i--;
				t1 = t1.next;
			}
		}else{
			int i = len2-len1;
			while(i!=0){
				i--;
				t2 = t2.next;
			}
		}
		//同步遍历，直到结点相同为止
		while(t1!=null&&t2!=null){
			if(t1==t2)
				break;
			t1 = t1.next;
			t2 = t2.next;
		}
		
		return t1;
	}
	//判断两个链表是否相交
	/*
	 * 思路：如果两个单向链表相交，则它们的尾节点肯定相同，如果不相同，则说明不相交
	 */
	public boolean isIntersect(Node h1,Node h2){
		if(h1==null || h2==null)
			return false;
		
		Node tail1 = h1;
		Node tail2 = h2;
		
		while(tail1.next!=null)
			tail1 = tail1.next;
		while(tail2.next!=null)
			tail2 = tail2.next;
		
		return tail1 == tail2;
	}
	
	//找到环入口
	/*
	 * 思路：首先通过快慢指针获取到第一次相遇的节点，
	 * 	然后再一个从head开始，一个从相遇的点开始，单步走，必定相遇，相遇第一次的点就是环入口点
	 *  
	 */
	public Node isLoopNode(Node head){
		if(head==null)
			return null;
		Node fast = head;
		Node slow = head;
		Node first = null;//第一次相遇的结点
		//通过快慢指针获取到第一次相遇的节点
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				first = fast;
				break;
			}
		}
		
		if(fast==null || fast.next==null || first == null){
			return null;
		}
		//一个从head开始，一个从相遇的点开始，单步走，必定相遇
		Node start = head;
		while(start != first){
			start = start.next;
			first = first.next;
		}
		
		return start;
	}
	//判断链表中是否有环
	/*
	 * 思路：使用一个快指针和慢指针，同时遍历，如果能得到快指针等于了慢指针，说明有环；
	 * 								  如果快指针等于了null，说明没有环
	 */
	public  boolean isLoop(Node head) {
		if(head==null)
			return false;
		Node fast = head;//快指针 +2
		Node slow = head;//慢指针 +1
		while(fast!=null&&fast.next!=null){
			
			fast=fast.next.next;
			slow=slow.next;
			
			if(fast==slow){
				return true;
			}
		}
		return false;
	}

	//寻找单链表的中间节点
	/*
	 * 思路：不用遍历两次得到length求出mid再遍历
	 * 		可以使用两个指针，同时遍历，一个快 走2步，一个慢 走1步
	 * 		当快的走到尾部时，慢的正好在中间
	 * 		（如果链表为偶数，中间两个都算）
	 */
	public Node findMidNode(){
		if(head==null){
			return null;
		}
		Node fast = head;//+2
		Node slow = head;//+1
		while(fast!=null){
			if(fast.next==null){
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	//从尾到头输出单链表
	/*
	 * 思路：可以用栈，但是要开辟多余的空间
	 * 想到栈 就能想到递归，递归的本质就是一个栈结构
	 * 使用递归输出后面的节点，再输出本节点
	 */
	public void postPrint(Node node){
		if(node!=null){
			postPrint(node.next);
			System.out.print(node.data+" ");
		}
		
	}
	
	//找到倒数第k个元素
	/*
	 * 思路：指定两个指针，一个p1，一个p2,
	 * p1需要向前移动k-1个位置
	 * 然后p1，p2同时遍历链表，只到p1->next指向null，p2正好指向倒数第k个元素
	 */
	public Node findKPost(int k) {
		if(k<1)
			return null;
		Node p1 = head;
		Node p2 = head;
		for(int i=0 ; i<k-1;i++){
			p1 = p1.next;
		}
		if(p1==null){
			System.out.println("k值有问题");
			return null;
		}
		while(p1.next!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	//删除重复的数
	/*
	 * 思路：用两个循环，外循环正常遍历链表，内循环从当前cur节点向后遍历，遇到重复的节点就删除。
	 */
	public void deleteRepeat() {
		if(head == null)
			return ;
		Node p = head;
		
		while(p!=null){//外循环
			Node q = p;
			while(q.next!=null){//内循环
				if(p.data==q.next.data){
					q.next = q.next.next;
					//q = q.next;
				}else
					q = q.next;
			}
			p = p.next;
		}
	}
	//向链表添加
	/*
	 * 思路：从head节点开始遍历，遇到cur->next为null时，添加新节点
	 */
	public void addLinkedList(int d){
		Node newNode = new Node(d);
		if(head == null){
			head = newNode;
			return;
		}
		//Node preNode = null;
		Node curNode = head;
		while(curNode!=null){
			//preNode = curNode;
			if(curNode.next==null){
				curNode.next = newNode;
				return;
			}
			curNode = curNode.next;
		}
	}
	//删除链表指定位置的节点
	/*
	 * 思路：先判断是否为头结点，很容易去掉头结点
	 * 	    标量i为2，开始从第二个节点遍历，判断i==index，如果是则删除第i节点
	 */
	public  boolean deleteLinkedList(int index){
		if(index==1)
		{
			head = head.next;
			return true;
		}
		int i =2;
		Node preNode = head;
		Node curNode = head.next;
		while(curNode!=null){
			//preNode = curNode;
			if(index==i){
				preNode.next = curNode.next;
				return true;
			}
			i++;
			preNode = curNode;
			curNode = curNode.next;
		}
		return false;
	}
	//打印链表
	public  void print(){
		if(head==null)
			return;
		Node curNode = head;
		while(curNode!=null){
			System.out.print(curNode.data+" ");
			curNode = curNode.next;
		}
	}
	//链表排序  从小到大
	/*
	 * 用两个循环，外循环正常遍历链表，内循环从当前cur节点开始与后面的节点值进行比较，
	 * 如果小于cur节点的值，便进行值得交换
	 * 然后，再继续遍历下一个节点进行比较
	 */
	public  void sortLinkedList(){
		if(head==null){
			return;
		}
		Node curNode = head;
		Node preNode;
		while(curNode!=null){
			preNode = curNode;
			while(curNode.next!=null){
				int temp ;
				if(preNode.data > curNode.next.data){
					temp = preNode.data;
					preNode.data = curNode.next.data;
					curNode.next.data = temp;
				}
				curNode = curNode.next;
			}
			curNode = preNode.next;
			
		}
		
	}
	//输出链表长度
	public  int getLength(){
		int length=0;
		if(head == null)
			return length;
		Node curNode = head;
		while(curNode!=null){
			length++;
			curNode = curNode.next;
		}
		return length;
	}
	
}
class Node{
	int data;
	Node next = null;
	Node(int data){
		this.data = data;
	}
}

package offer;

/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class offer10 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode next1 = new ListNode(1);
		head.next = next1;
		
		ListNode next2 = new ListNode(2);
		next1.next = next2;
		
		ListNode next3 = new ListNode(3);
		next2.next = next3;
		
		ListNode next4 = new ListNode(4);
		next3.next = next4;
		
	//	next4.next = head;
		ListNode entry = deleteDuplication(head);
		while(entry!=null){
			System.out.println(entry.val);
			entry = entry.next;
		}
			
	}
	public static ListNode deleteDuplication(ListNode pHead)
    {
		
		if(pHead==null)
			return null;
		ListNode p = pHead;// p当前节点
		ListNode n = new ListNode(0);//n.next 指的是链头
		ListNode pre = n;//pre 指的是当前节点的 上一个节点
		n.next = pHead;
		boolean flag = false;
		while(p!=null){
			
			ListNode q = p.next;// q 当前节点的 下一个节点
			
			if(q == null) break;
			
			 if(q.val == p.val){//下一个节点和当前节点的值是否相等
				 while(q != null && q.val == p.val){
					 q = q.next;
				 }
				 pre.next = q;
				 p = q;
			 }else{
				 if(!flag){//是否找到链表的头部
					 n.next = p;
					 flag = true;//找到链表的头部了
				 }
				 pre = p;//把p 赋值给pre
				 p = q;//再把q 赋值给p
				
			 }
		}
		return n.next;
    }
}

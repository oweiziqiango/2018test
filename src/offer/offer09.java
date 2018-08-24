package offer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author Administrator
 *
 */
class ListNode {
	int val;
   ListNode next = null;

   ListNode(int val) {
       this.val = val;
   }
}
public class offer09 {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode next1 = new ListNode(1);
		head.next = next1;
		
		ListNode next2 = new ListNode(2);
		next1.next = next2;
		
		ListNode next3 = new ListNode(3);
		next2.next = next3;
		
		ListNode next4 = new ListNode(4);
		next3.next = next4;
		
		next4.next = head;
		ListNode entry = EntryNodeOfLoop(head);
		if(entry!=null)
			System.out.println(entry.val);
	}
	
	public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
		ListNode first = null;
		if(pHead == null){
			return null;
		}
		ListNode fast = pHead;
		ListNode slow = pHead;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				first = fast;
				break;
			}
		}
		
		if(fast==null || fast.next==null || first == null){
			return null;
		}
		
		ListNode start = pHead;
		while(start!=first){
			start = start.next;
			first = first.next;
		}
		
        return start;
    }
}

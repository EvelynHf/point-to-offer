package reverseList;

public class ReverseList {

}

class Solution2 {
	public ListNode reverseList(ListNode head){
		if(null == head) return null;
		ListNode[] headAndTail = new ListNode[2];
		headAndTail = recursiveReverseList(head);
		return headAndTail[0];
	}
	private ListNode[] recursiveReverseList(ListNode head){
		ListNode[] headAndTail = new ListNode[2];
		if(null == head.next){
			headAndTail[0] = head;
			headAndTail[1] = head;
			
		}else{
			headAndTail = recursiveReverseList(head.next);
			headAndTail[1].next = head;
			head.next = null;
			headAndTail[1] = head;
		}
		return headAndTail;
	}
}



class Solution{
	public ListNode reverseList(ListNode head){
		if(null == head || null == head.next) return head;
		ListNode pNew = head;
		ListNode point = head.next;
		ListNode temp = null;
		head.next = null;
		while(null != point){
			temp = point;
			point = point.next;
			temp.next = pNew;
			pNew = temp;
		}
		return pNew;
	}
}

class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){ this.val = val;}
}
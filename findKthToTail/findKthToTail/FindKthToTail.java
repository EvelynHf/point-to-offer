package findKthToTail;

public class FindKthToTail {

}

class Solution{
	public ListNode findKthToTail(ListNode head, int k){
		if(null == head || k <= 0) return null;
		ListNode first = head;
		ListNode second = null;
		int index = 0;
		while(index < k - 1 && first != null) {
			first = first.next;
			index++;
		}
		if(index == k - 1 && first != null){
			second = head;
			while(first.next != null){
				first = first.next;
				second = second.next;
			}
		}
		return second;
	}
}


class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){ this.val = val;}
}
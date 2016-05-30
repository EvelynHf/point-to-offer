package mergeTwoList;

public class MergerTwoList {

}

class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(null == list1) return list2;
        if(null == list2) return list1;
        ListNode head;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        head.next = null;
        ListNode point = head;
        while(null != list1 && null != list2){
            if(list1.val <= list2.val){
                point.next = list1;
                list1 = list1.next;
            }else{
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }
        if(list1 == null) point.next = list2;
        if(list2 == null) point.next = list1;
        return head;
    } 
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
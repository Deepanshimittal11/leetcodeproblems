/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle = findemiddle(head);
        ListNode lefthead = head;
        ListNode righthead = middle.next;
        middle.next = null;
        lefthead = sortList(lefthead);
        righthead = sortList(righthead);
        return merge2lists(lefthead,righthead);
    }
    public ListNode merge2lists(ListNode ls1, ListNode ls2){
       
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;

        while(ls1!=null && ls2!=null){
            if(ls1.val < ls2.val){
                temp.next = ls1;
                temp = ls1;
                ls1 = ls1.next;
            }
            else{
                temp.next = ls2;
                temp = ls2;
                ls2 = ls2.next;
            }
        }
        if(ls1 != null) temp.next = ls1;
        else temp.next = ls2;

        return dNode.next;
    }
    public ListNode findemiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
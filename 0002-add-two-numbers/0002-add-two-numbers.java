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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(t1!=null && t2!=null){
            int sum = (t1.val + t2.val + carry);
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            carry = sum/10;
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1!=null){
            int sum = (t1.val + carry);
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            t1 = t1.next;
            carry = sum/10;
        }
        while(t2!=null){
            int sum = (t2.val + carry);
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            t2 = t2.next;
            carry = sum/10;
        }
        if(carry==1){
            curr.next = new ListNode(1);
        }

        return dummy.next;
    }
}
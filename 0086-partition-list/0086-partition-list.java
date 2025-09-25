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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode dummy1 = new ListNode(-1);
        ListNode curr1 = dummy1;

        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                curr.next = new ListNode(temp.val);
                curr = curr.next;
            }else{
                curr1.next = new ListNode(temp.val);
                curr1 = curr1.next;
            }
            temp = temp.next;
        }
        curr.next = dummy1.next;
        return dummy.next;
    }
}
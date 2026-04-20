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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        int cnt = 0;
        ListNode odd = new ListNode(-1);
        ListNode odd1 = odd;

        ListNode even = new ListNode(-1);
        ListNode even1 = even;

        ListNode temp = head;
        while(temp!=null){
            if(cnt % 2 != 0){
                even1.next = temp;
                even1 = even1.next;
            }
            else{
                odd1.next = temp;
                odd1 = odd1.next;
            }
            temp = temp.next;
            cnt++;
        }

        even1.next = null;
        odd1.next = even.next;
        return odd.next;
    }
}
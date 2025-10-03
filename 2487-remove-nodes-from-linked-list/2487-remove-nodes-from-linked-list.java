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
    public ListNode removeNodes(ListNode head) {
        //now head is 8
        head = reverse(head);

        // max = -infinite
        int max = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(head!=null){
            // if 8 >= -infinite (true); then in 2nd loop run 3>=8 (false) then 13>=8 (true)  then 2>=13 (false) then 5>=13 (false);
            if(head.val >= max){
                //max = 8
                max = head.val;
                //curr abhi is on -1 then (-1 -> 8 -> 13)
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        //8->13->null
        curr.next = null;

        return reverse(dummy.next);
    }
    // 5->2->13->3->8
    // reverse the list
    // 8->3->13->2->5
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
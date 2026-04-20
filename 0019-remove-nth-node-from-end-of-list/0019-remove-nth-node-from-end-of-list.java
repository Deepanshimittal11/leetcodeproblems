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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }

        if(cnt == n) return head.next;

        int k = cnt-n-1;
        temp = head;
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(k==0) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            k--;
        }
        return temp;
    }
}
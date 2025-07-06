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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;
        if(head==null || head.next==null) return head;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        temp = head;
        ListNode first = head;
        for(int i=1;i<k;i++){
            first = first.next;
        }
        ListNode last = head;
        for(int i=1;i<cnt-k+1;i++){
            last = last.next;
        }
        int curr = first.val;
        first.val = last.val;
        last.val = curr;
        return head;
    }
}
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;

        int length =1;
        ListNode tail = head;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }        
        k = k%length;
        if(k==0) return head;
        tail.next = head;
        ListNode newlastnode = findnthNode(head, length-k);
        head = newlastnode.next;
        newlastnode.next = null;
        return head;
    }
    private ListNode findnthNode(ListNode node, int n){
        while(n>1){
            node = node.next;
            n--;
        }
        return node;
    }
}
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
        int len =1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if(k==0) return head;
        tail.next = head;
        ListNode newlastnode = findnthnode(head, len-k);
        head = newlastnode.next;
        newlastnode.next = null;
        return head;
    }
    private ListNode findnthnode(ListNode node, int n){
        while(n>1){
            node = node.next;
            n--;
        }
        return node;
    }
}
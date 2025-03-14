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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head== null || k==1){
            return head;
        }
        ListNode temp = head;
        ListNode prevnode = null;
        ListNode nextnode = null;
        int length =0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        temp = head;
        while(length>=k){
            ListNode kthnode = findKthNode(temp , k);
            nextnode = kthnode.next;
            ListNode prev = null;
            ListNode curr = temp;

            while(curr != nextnode){
                ListNode nexttemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nexttemp;
            }
            
            if(prevnode == null){
                head = prev;
            }
            else{
                prevnode.next = prev;
            }
            temp.next = nextnode;
            prevnode = temp;
            temp = nextnode;
            length -= k;
        }
        return head;
    }
    private ListNode findKthNode(ListNode node, int k){
        while(node!=null && k>1){
            node = node.next;
            k--;
        }
        return node;
    }
}
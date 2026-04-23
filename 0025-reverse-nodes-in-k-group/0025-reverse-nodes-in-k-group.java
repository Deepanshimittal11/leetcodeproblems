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
        ListNode temp = head;
        ListNode nextnode = null, prevnode = null;

        while(temp!=null){
            ListNode kthnode = findkthnode(temp, k);
            if(kthnode == null){  //if k elem are not forming.
                if(prevnode != null){
                    prevnode.next = temp;
                }
                break;
            }
            nextnode = kthnode.next;
            kthnode.next = null;
            reverse(temp);
            if(temp==head){
                head = kthnode;
            }
            else{
                prevnode.next = kthnode;
            }
            prevnode = temp;
            temp = nextnode;
        }
        return head;
    }
    public ListNode findkthnode(ListNode temp, int k){
        k -= 1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        ListNode curr = temp;
        while(curr!=null){
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        return prev;
    }
}
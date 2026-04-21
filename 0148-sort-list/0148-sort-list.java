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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode middle = findmiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        ListNode result = mergeLists(leftHead, rightHead);
        return result;
    }
    public ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeLists(ListNode lh, ListNode rh){
        ListNode l1 = lh;
        ListNode r1 = rh;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1!=null && r1!=null){
            if(l1.val < r1.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = r1;
                r1 = r1.next;
            }
            curr = curr.next;
        }
        if(l1!=null) curr.next = l1;
        if(r1!=null) curr.next = r1;
        return dummy.next;
    }
}
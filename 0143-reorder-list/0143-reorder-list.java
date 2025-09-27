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
    public void reorderList(ListNode head) {

        if(head==null || head.next==null) return;

        ListNode slow = head;
        ListNode fast = head;

        //find middle 
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        //slow ke next node ko curr maan lia &
        ListNode curr = slow.next;
        // then, slow and curr node break krdia 
        slow.next = null;

        //second half ko reverse krdia!
        while(curr!=null){
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }

        ListNode first = head;
        ListNode sec = prev;
        //merge both lists
        // list1 = 1->2->3->null & list2 = 5->4->null
        //after merge: 1->5->2->4->3->null
        while(sec!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = sec.next;
            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }
    }
}
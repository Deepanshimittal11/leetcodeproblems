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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while(l1!=null){
            st1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null){
            st2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        int digit = 0;
        ListNode head = null;

        //carry!=0 means if l1=5 and l2=5 it will give only if we won't put this statement. 
        while(!st1.isEmpty() || !st2.isEmpty() || carry!=0){
            int sum = carry;
            if(!st1.isEmpty()) sum += st1.pop();
            if(!st2.isEmpty()) sum += st2.pop();

            carry = sum/10;
            digit = sum%10;

            ListNode nextnode = new ListNode(digit);
            nextnode.next = head;
            head = nextnode;
        }
        return head;
    }
}
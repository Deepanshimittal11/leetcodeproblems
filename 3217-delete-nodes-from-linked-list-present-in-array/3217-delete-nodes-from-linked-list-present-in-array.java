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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(temp!=null){
            if(!set.contains(temp.val)){
                prev.next = new ListNode(temp.val);
                prev = prev.next;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
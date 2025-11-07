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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(ListNode node : lists){
            if(node!=null) pq.add(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode nextnode = pq.poll();
            curr.next = nextnode;
            curr = curr.next;

            if(nextnode.next != null){
                pq.add(nextnode.next);
            }
        }
        return dummy.next;
    }
}
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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        if(head==null || head.next==null) return head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(j)<list.get(i)){
                    int tempi = list.get(j);
                    list.set(j ,list.get(i));
                    list.set(i, tempi);
                }
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i=0;i<list.size();i++){
            curr.next = new ListNode(list.get(i));
            curr = curr.next; 
        }
        return dummy.next;
    }
}
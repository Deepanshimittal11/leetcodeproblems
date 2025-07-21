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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> a = new ArrayList<>();
        for(ListNode curr = head;curr!=null;curr=curr.next){
            a.add(curr.val);
        }
        int[] res = new int[a.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<a.size();i++){
            while(!stack.isEmpty() && a.get(i)>a.get(stack.peek())){
                int ind = stack.pop();
                res[ind] = a.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
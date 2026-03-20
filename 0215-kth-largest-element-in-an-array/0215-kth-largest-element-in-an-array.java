class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        // for(int i=0;i<nums.length;i++){
        //     pq.offer(nums[i]);
        // }
        // while(!pq.isEmpty() && k>1){
        //     pq.poll();
        //     k--;
        // }
        // return pq.peek();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
}
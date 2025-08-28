class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            int diff = first-second;
            if(diff==0) continue;
            else pq.offer(diff);
        }
        if(pq.size()==1) return pq.peek();
        else return 0;
    }
}
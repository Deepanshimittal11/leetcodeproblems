class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int pile : piles){
            pq.offer(pile);
        }
        int sum = 0;
        int res = 0;
        while(k-- > 0){
            int a = pq.poll();
            if(a%2==0)  res = a/2;
            else res = (a/2)+1;
            pq.offer(res);
        }
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
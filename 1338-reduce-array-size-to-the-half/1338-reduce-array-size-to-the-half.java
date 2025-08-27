class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = arr.length;
        int cnt = 0;
        for(int num : arr){
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : mpp.values()){
            pq.offer(num);
        }
        int removedItems = 0;
        while(removedItems<n/2){
            removedItems += pq.poll();
            cnt++;
        }
        return cnt;
    }
}
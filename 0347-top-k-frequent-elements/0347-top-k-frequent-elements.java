class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        for(int num : nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
            for(Map.Entry<Integer, Integer> entry : mpp.entrySet()){
                heap.offer(entry);
                if(heap.size()>k){
                    heap.poll();
                }
            }

        int[] res = new int[k];
        int i=0;
        while(!heap.isEmpty()){
            res[i++] = heap.poll().getKey();
        }
        return res;
    }
}
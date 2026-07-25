class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> mpp.get(a)-mpp.get(b));
        for(int key : mpp.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int ind= 0;
        while(!pq.isEmpty()){
            ans[ind++] = pq.poll();
        }
        return ans;
    }
}
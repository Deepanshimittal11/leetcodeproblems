class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // int preSum =0;
        // int cnt =0;
        // for(int i=0;i<nums.length;i++){
        //     preSum += nums[i];
        //     int remove = preSum-k ;
        //     cnt += map.getOrDefault(remove, 0);
        //     map.put(preSum, map.getOrDefault(preSum, 0) + 1); 
        // }
        // return cnt;

        return generateSubsets(nums, 0,0, k);
        
    }
    private int generateSubsets(int[] nums, int start, int s, int k){
        if(start==nums.length){
            return 0;
        }
        int cnt =0;
        int sum =s;
        for(int i=start;i<nums.length;i++){
            sum+=nums[i];

            if(sum==k){
                cnt++;
            }
        }

        cnt += generateSubsets(nums,start+1, s, k);
        return cnt;
    }
}
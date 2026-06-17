class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int sum = 0, cnt = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            if(mpp.containsKey(sum - k)){
                cnt += mpp.get(sum-k);
            }
            mpp.put(sum, mpp.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int l=0;
        long sum = 0;
        long maxsum = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
            if(i-l+1 > k){
                sum -= nums[l];
                mpp.put(nums[l], mpp.get(nums[l])-1);
                if(mpp.get(nums[l])<1) mpp.remove(nums[l]);
                l++;
            }
            if(i-l+1==k && mpp.size()==k){
                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum;
    }
}
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minpref = new long[k];

        long ans = Long.MIN_VALUE;
        long pref = 0;

        for(int i=0;i<k;i++){
            minpref[i] = Long.MAX_VALUE;
        }
        minpref[0] = 0;

        for(int i=0;i<n;i++){
            pref += nums[i];
            int mod = (i+1)%k;
            if(minpref[mod] != Long.MAX_VALUE){
                ans = Math.max(ans, pref-minpref[mod]);
            }
            minpref[mod] = Math.min(minpref[mod], pref);
        }
        return ans;
    }
}
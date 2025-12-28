class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long mini = Integer.MAX_VALUE;
        long[] suffix = new long[n];

        for(int i=n-1;i>=0;i--){
            mini = Math.min(mini, nums[i]);
            suffix[i] = mini;
        }

        long ans = Integer.MIN_VALUE;
        long pre = 0;
        for(int i=0;i<n-1;i++){
            pre += nums[i];
            ans = Math.max(ans, pre-suffix[i+1]);
        }
        return ans;
    }
}
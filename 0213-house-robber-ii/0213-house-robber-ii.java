class Solution {
    int[] dp1;
    int[] dp2;
    public int rob(int[] nums) {
        int n = nums.length;
        dp1 = new int[n];
        dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        if(n == 1) return nums[0];
        return Math.max(helper(nums, n-2, 0, dp1), helper(nums, n-1, 1, dp2));
    }
    public int helper(int[] nums, int n, int ind, int[] dp){
        if(n == ind) return nums[ind];
        if(n < ind) return 0;
        if(dp[n] != -1) return dp[n];

        int take = helper(nums, n-2, ind, dp) + nums[n];
        int skip = helper(nums, n-1, ind, dp);

        return dp[n] = Math.max(take, skip);
    }
}
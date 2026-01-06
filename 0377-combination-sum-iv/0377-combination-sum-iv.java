class Solution {
    Integer[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target+1];

        int res = helper(nums, target);
        return res;
    }
    public int helper(int[] nums, int target){
        if(target==0) return 1;
        if(target<0) return 0;
        if(dp[target] != null) return dp[target];

        int ways = 0;
        for(int i=0;i<nums.length;i++){
            ways += helper(nums, target-nums[i]);
        }
        return dp[target] = ways;
    }
}
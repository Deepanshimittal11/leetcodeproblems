class Solution {
    boolean[] dp;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new boolean[n];
        return solve(nums, n, 0);
    }
    public boolean solve(int[] nums, int n, int ind){
        if(ind==n-1) return true;
        if(ind>=n) return false;
        if(dp[ind] != false) return dp[ind];

        for(int i=1;i<=nums[ind];i++){
            if(solve(nums, n, ind+i)==true) return dp[ind] = true;
        }
        return dp[ind] = false;
    }
}
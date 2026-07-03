class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum%2 != 0) return false;

        Boolean[][] dp = new Boolean[n][sum/2+1];
        for(Boolean[] rows : dp){
            Arrays.fill(rows, null);
        }
        return helper(nums, sum/2, n-1, dp);
    }
    public boolean helper(int[] nums, int sum, int ind, Boolean[][] dp){
        if(sum == 0) return true;
        if(ind == 0) return nums[0]==sum;
        if(dp[ind][sum] != null) return dp[ind][sum];

        boolean notTake = helper(nums, sum, ind-1, dp);

        boolean take = false;
        if(nums[ind] <= sum){
            take = helper(nums, sum-nums[ind], ind-1, dp);
        }

        return dp[ind][sum] = (take || notTake);
    }
}
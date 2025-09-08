class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum += num;

        if((target+sum)%2!=0 || Math.abs(target)>sum) return 0;

        int p = (target+sum)/2;

        return cntSubset(nums, p);
    }
    public int cntSubset(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int num : nums){
            for(int i=target;i>=num;i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
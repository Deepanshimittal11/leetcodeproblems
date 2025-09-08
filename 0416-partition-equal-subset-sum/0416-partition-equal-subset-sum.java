class Solution {
    public boolean canPartition(int[] nums) {
        // Arrays.sort(nums);
        // int sum = 0;
        // for(int i=0;i<nums.length;i++){
        //     sum += nums[i];
        // }
        // int res = 0;
        // if(sum%2==0) res = sum/2;
        // else return false;
        // sum = 0;
        // int l=0;
        // for(int i=0;i<nums.length;i++){
        //     sum += nums[i];
        //     while(sum>res){
        //         sum -= nums[l];
        //         l++;
        //     }
        //     if(sum==res) {
        //         return true;
        //     }
        // }
        // return false;

        //with the help of DP:
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        } 
        if(sum%2!=0) return false;
        //we have partition the arr in equal parts. So,
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num : nums){
            for(int i = target;i>=num;i--){
                dp[i] = dp[i]||dp[i-num];
            }
        }
        return dp[target];
    }
}
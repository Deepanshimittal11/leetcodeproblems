class Solution {
    public int numSubarraysWithSum(int[] nums, int goal){
        return helper(nums,goal)-helper(nums,goal-1);
    }
    private int helper(int[] nums, int goal) {
        if(goal<0) return 0;
        int l=0;
        int r=0;
        int n = nums.length;
        int sum = 0;
        int cnt = 0;
        for(r=0;r<n;r++){
            sum += nums[r];
            while(sum>goal){
                sum -= nums[l];
                l = l+1;
            }
            cnt += r-l+1;
        }
        return cnt;
    }
    
}
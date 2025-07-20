class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int r=0;
        int[] ans = new int[n];
        while(r<n){
            ans[r] = (nums[r]+sum);
            sum += nums[r];
            r++;
        }
        return ans;
    }
}
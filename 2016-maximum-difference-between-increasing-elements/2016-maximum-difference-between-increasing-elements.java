class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int mini = nums[0];
        int maxdiff = -1;
        for(int i=1;i<n;i++){
            if(nums[i]>mini){
                maxdiff = Math.max(maxdiff, nums[i]-mini);
            }
            else{
                mini = nums[i];
            }
        }
        return maxdiff;
    }
}
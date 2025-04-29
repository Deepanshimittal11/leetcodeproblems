class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int mini = nums[0];

        for(int i=0;i<n;i++){
            if(nums[i]<mini){
                mini = nums[i];
            }
            sum += nums[i];
        }
        return (sum-n*mini);
    }
}
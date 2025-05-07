class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operation = 0;
        int diff = 0;
        if(n==1){
            return 0;
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]>=nums[i+1]){
                diff = nums[i]-nums[i+1]+1;
                nums[i+1] = nums[i+1]+diff;
                operation += diff;
            }            
        }
        return operation;
    }
}
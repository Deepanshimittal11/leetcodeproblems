class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mini ;
        int result = 0;
        for(int i=0;i<n-1;i+=2){
            mini = Math.min(nums[i],nums[i+1]);
            result += mini;
        }
        return result;
    }
}
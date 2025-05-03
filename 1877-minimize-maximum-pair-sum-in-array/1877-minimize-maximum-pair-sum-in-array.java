class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int start = 0;
        int end = n-1;
        int sum=0;
        int maxSum = 0;
        while(start<end){
            sum = (nums[start]+nums[end]);
            maxSum = Math.max(sum,maxSum);
            start++;
            end--;
        }
        return maxSum;
    }
}
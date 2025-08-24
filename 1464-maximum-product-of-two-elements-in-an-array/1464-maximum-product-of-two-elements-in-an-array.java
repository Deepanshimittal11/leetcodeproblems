class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int res = (nums[n]-1)*(nums[n-1]-1);
        return res;
    }
}
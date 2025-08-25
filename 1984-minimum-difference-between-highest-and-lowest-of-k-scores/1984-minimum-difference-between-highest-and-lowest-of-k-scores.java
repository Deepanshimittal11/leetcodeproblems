class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int n = k-1;
        int diff = nums[n]-nums[i];
        while(n<nums.length){
            int temp = nums[n]-nums[i];
            diff = Math.min(temp,diff);
            i++;
            n++;
        }
        return diff;
    }
}
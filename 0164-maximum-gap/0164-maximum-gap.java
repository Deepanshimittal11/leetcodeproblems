class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums.length==1){
            return 0;
        }
        return (nums[1]-nums[0]);
    }
}
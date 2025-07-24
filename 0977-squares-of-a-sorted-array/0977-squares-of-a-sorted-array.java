class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int pdt = nums[i]*nums[i];
            ans[i] = pdt;
            pdt = 1;
        }
        Arrays.sort(ans);
        return ans;
    }
}
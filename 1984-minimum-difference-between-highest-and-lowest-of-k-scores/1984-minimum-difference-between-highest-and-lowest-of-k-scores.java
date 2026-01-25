class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0;
        int K = k-1;
        int diff = nums[K] - nums[i];
        while(K < n){
            int temp = nums[K] - nums[i];
            diff = Math.min(diff, temp);
            i++;
            K++;
        }
        return diff;
    }
}

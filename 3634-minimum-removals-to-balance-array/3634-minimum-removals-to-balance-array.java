class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l=0;
        int len = 0;

        for(int i=0;i<n;i++){
            while((long)nums[i] > (long)nums[l]*k){
                l++;
            }
            len = Math.max(len, i-l+1);
        }
        return n-len;
    }
}
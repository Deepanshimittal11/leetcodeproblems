class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int len = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int n = nums.length;
        for(r=0;r<n;r++){
            sum += nums[r];
            while(sum >= target){
                minlen = Math.min(minlen,r-l+1);
                sum -= nums[l];
                l = l+1;
            }                    
        }
        return (minlen == Integer.MAX_VALUE) ? 0 : minlen;
    }
}
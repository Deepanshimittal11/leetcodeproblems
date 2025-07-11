class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0, zeros=0,maxlen =0;
        int n = nums.length;
        while(r<n){
            if(nums[r]==0) zeros++;
            while(zeros > k) {
                if(nums[l]==0) zeros--;
                l++;
            }            
            maxlen = Math.max(maxlen,r-l+1);          
            r++;
        }
        return maxlen;
    }
}
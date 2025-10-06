class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int n = nums.length;
        int left = 0;

        for(int i=0;i<n;i++) xor ^= nums[i];
        if(xor != 0) return n;
        while(left < n){
            xor ^= nums[left];
            if(xor != 0) return n-left-1;
            left++;
        }
        return xor;
    }
}
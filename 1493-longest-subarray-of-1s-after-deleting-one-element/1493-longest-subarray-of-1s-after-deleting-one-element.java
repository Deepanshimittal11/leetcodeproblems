class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
        int l = 0;
        int n = nums.length;
        int maxlen = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==0) k--;

            while(k<0){
                if(nums[l]==0) k++;
                l++;
            }
            maxlen = Math.max(maxlen, i-l);
        }
        return maxlen;
    }
}
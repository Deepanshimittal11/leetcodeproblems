class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int maxlen = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==0) k--;
            while(k<0){
                if(nums[l]==0) k++;
                l++;
            }
            maxlen = Math.max(maxlen, i-l+1);
        }
        return maxlen;
    }
}
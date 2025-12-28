class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int cntpos = 0;
        int cntneg = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) cntneg++;
            else if(nums[i]>0) cntpos++;
        }
        return Math.max(cntpos, cntneg);
    }
}
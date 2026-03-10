class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        int cnt = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==1) cnt++;
            else cnt = 0;
            maxlen = Math.max(maxlen, cnt);
        }
        return maxlen;
    }
}
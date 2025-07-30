class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int len = 0;
        int maxlen = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        for(int num : nums){
            if(num == max){
                len++;
                maxlen = Math.max(maxlen, len);
            }
            else{
                len = 0;
            }
        }
        return maxlen;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int len = 1;
        int maxlen = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            else if(nums[i]==nums[i-1]+1){
                len++;
                maxlen = Math.max(maxlen,len);
            }
            else{
                len = 1;
            } 
        }
        return maxlen;
    }
}
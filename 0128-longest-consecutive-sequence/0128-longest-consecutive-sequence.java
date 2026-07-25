class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 1;
        int cnt = 1;
        int n = nums.length;

        if(n==0) return 0;
        Arrays.sort(nums);

        for(int i=0;i<n-1;i++){
            if(nums[i]+1==nums[i+1]){
                cnt++;
            }
            else if(nums[i] == nums[i+1]){
                continue;
            }
            else{
                cnt=1;
            }
            maxlen = Math.max(maxlen, cnt);
        }
        return maxlen;
    }
}
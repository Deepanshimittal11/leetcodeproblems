class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int sum = 0, cnt = 0;
        int sum1 = 0;
        for(int num : nums){
            sum += num;
        }
        for(int i=0;i<n-1;i++){
            sum -= nums[i];
            sum1 += nums[i];
            if(sum1 >= sum){
                cnt++;
            }
        }
        return cnt;
    }
}
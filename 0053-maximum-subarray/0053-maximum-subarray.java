class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            if(sum < 0){
                sum =0;
            }
            if(sum > maxi){
                maxi = sum;
            }
            if(maxi < 0){
            return -1;
        }
        
        }
        return maxi;
    }
}
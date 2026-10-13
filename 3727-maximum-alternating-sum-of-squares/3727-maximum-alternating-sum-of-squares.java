class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        long sum = 0;
        long sum1 = 0;
        for(int i=0;i<n/2;i++){
            sum1 += nums[i]*nums[i]; 
        }
        for(int i=n/2;i<n;i++){
            sum += nums[i]*nums[i];
        }
        return (sum-sum1);
    }
}
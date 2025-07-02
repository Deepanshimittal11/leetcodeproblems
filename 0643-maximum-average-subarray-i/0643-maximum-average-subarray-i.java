class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double maxAvg = 0;
        for(int i=0;i<k;i++){
            maxAvg += nums[i];
        }
        double avgSum = maxAvg;

        for(int i=k;i<nums.length;i++){
            avgSum += nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg, avgSum);
        }
        return maxAvg/k;
    }
}
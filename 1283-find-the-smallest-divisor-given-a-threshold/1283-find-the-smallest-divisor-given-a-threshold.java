class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getSum(nums, mid) <= threshold) {
                right = mid;  
            } else {
                left = mid + 1;  
            }
        }
        
        return left;
    }
    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;  
        }
        return sum;

    }
}
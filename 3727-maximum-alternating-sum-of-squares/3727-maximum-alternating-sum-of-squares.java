class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] dummy = new int[n];
        for(int i=0;i<n;i++){
            dummy[i] = Math.abs(nums[i]);
        }
        Arrays.sort(dummy);
        long sum = 0;
        for(int i=n-1;i>=n/2;i--){
            sum += dummy[i]*dummy[i];
        }
        for(int i=n/2-1;i>=0;i--){
            sum -= dummy[i]*dummy[i];
        }
        return sum;
    }
}
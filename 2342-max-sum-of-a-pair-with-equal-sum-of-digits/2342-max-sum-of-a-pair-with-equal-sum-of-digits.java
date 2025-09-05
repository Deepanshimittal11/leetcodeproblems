class Solution {
    public int maximumSum(int[] nums) {

        Map<Integer, Integer> mpp = new HashMap<>();
        int maxSum = -1;

        for(int n : nums){
            int digits = sumDigit(n);
            if (mpp.containsKey(digits)) {
                maxSum = Math.max(maxSum, n + mpp.get(digits));
                mpp.put(digits, Math.max(mpp.get(digits), n));
            } else {
                mpp.put(digits, n);
            }
        }
        return maxSum;
    }
    private int sumDigit(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
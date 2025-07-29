class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n && j - i + 1 <= r; j++) {
                sum += nums.get(j);
                int len = j - i + 1;

                if (len >= l && sum > 0) {
                    minSum = Math.min(minSum, sum);
                    found = true;
                }
            }
        }
        return found ? minSum : -1;
    }
}
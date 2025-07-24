class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // int n = nums.length;
        int mod = 1000000007;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                ans.add(sum);
            }
        }        
        Collections.sort(ans);
        // right = Math.min(right, ans.size());
        long totalsum = 0;
        for(int i=left-1;i<right;i++){
            totalsum = (totalsum + ans.get(i))%mod;
        }
        return (int)totalsum;
    }
}
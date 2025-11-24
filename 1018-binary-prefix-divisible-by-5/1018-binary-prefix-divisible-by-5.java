class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int prev = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            prev = ((prev << 1) + nums[i]) % 5;
            ans.add(prev==0);
        }
        return ans;
    }
}
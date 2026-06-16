class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(mpp.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = mpp.get(target - nums[i]);
            }
            mpp.put(nums[i], i);
        }
        return ans;
    }
}
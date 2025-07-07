class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int l = 0, len = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
            while(mpp.get(nums[i])>k){
                mpp.put(nums[l], mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                }
                l++;
            }
            len = Math.max(len, i-l+1);
        }
        return len;
    }
}
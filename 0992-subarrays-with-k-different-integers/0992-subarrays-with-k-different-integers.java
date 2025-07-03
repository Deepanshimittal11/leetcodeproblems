class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
    private int helper(int[] nums, int k){
        int l=0, r=0, cnt=0;
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(r=0;r<n;r++){
            mpp.put(nums[r], mpp.getOrDefault(nums[r],0)+1);
            if(mpp.get(nums[r])==1){
                k--;
            }
            while(k<0){
                mpp.put(nums[l], mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    k++;
                }
                l++;
            }
            cnt += r-l+1;
        }
        return cnt;
    }
}
class Solution {
    public long continuousSubarrays(int[] nums) {
        long cnt = 0;
        int l=0;
        int r=0;
        int n = nums.length;
        TreeMap<Integer, Integer> mpp = new TreeMap<>();
        while(r<n){
            mpp.put(nums[r], mpp.getOrDefault(nums[r],0)+1);
            while(mpp.lastKey()-mpp.firstKey()>2){
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l])<1) mpp.remove(nums[l]);
                l++;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
}
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int cnt = 0;
        int l=0, r=0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int k = set.size();
        while(r<n){
            mpp.put(nums[r], mpp.getOrDefault(nums[r],0)+1);
            while(mpp.size()==k){
                cnt += n-r;
                mpp.put(nums[l], mpp.get(nums[l])-1);
                if(mpp.get(nums[l])<1) mpp.remove(nums[l]);
                l++;
            }
            r++;
        }
        return cnt;
    }
}
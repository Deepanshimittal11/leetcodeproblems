class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int l=0;
        int n = nums.length;
        long cnt = 0;
        long res = 0;
        for(int i=0;i<n;i++){
            int num = nums[i];
            mpp.put(num, mpp.getOrDefault(num,0)+1);
            if(mpp.get(num)>1) cnt+= (long)(mpp.get(num)-1);
            while(cnt>=k){
                if(mpp.get(nums[l])>1) cnt-= (long)(mpp.get(nums[l])-1);
                mpp.put(nums[l], mpp.get(nums[l])-1);
                l++;
                res += (long)(n-i);
            }
        }
        return res;
    }
}
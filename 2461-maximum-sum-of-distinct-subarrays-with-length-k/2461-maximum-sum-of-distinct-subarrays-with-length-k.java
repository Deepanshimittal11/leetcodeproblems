class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int r=0, l=0;
        long sum = 0;
        long maxSum = 0;
        for(r=0;r<nums.length;r++){
            int num = nums[r];
            sum += num;
            mpp.put(num, mpp.getOrDefault(num,0)+1);
            if(r-l+1>k){
                int numDel = nums[l];
                sum -= numDel;
                mpp.put(numDel, mpp.get(numDel)-1);
                if(mpp.get(numDel)<1) mpp.remove(numDel);
                l++;
            }
            if(r-l+1==k && mpp.size()==k){
                maxSum = Math.max(maxSum, sum);
            }
            
        }
        return maxSum;
    }
}
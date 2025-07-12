class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int oddcnt = 0;
        int res = 0;
        for(int num : nums){
            if(num%2!=0) oddcnt++;
            res += mpp.getOrDefault(oddcnt-k,0);
            mpp.put(oddcnt, mpp.getOrDefault(oddcnt,0)+1);
        }
        return res;
    }
}
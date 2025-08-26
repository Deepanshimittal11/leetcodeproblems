class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxVal = 0;
        int l=0, res = 0;

        for(int r=0;r<n;r++){
            int num = nums.get(r);
            mpp.put(num, mpp.getOrDefault(num,0)+1);

            maxVal = Math.max(maxVal, mpp.get(num));
            while((r-l+1)-maxVal > k){
                int remove = nums.get(l);
                mpp.put(remove, mpp.get(remove)-1);
                l++;
            }
            res = Math.max(res, maxVal);
        }
        return res;
    }
}
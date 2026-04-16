class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0)+1);
        }

        int a = 0, b = 0;
        for(int key : mpp.keySet()){
            if(mpp.get(key)%2!=0) {
                b++;
            }
            a += mpp.get(key)/2;
        }
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}
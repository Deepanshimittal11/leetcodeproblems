class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0,-1);
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(k!=0){
                sum = sum%k;
            }
            if(mpp.containsKey(sum)){
                if(i-mpp.get(sum)>=2){
                    return true;
                }
            }
            else{
                mpp.put(sum,i);
            }
        }
        return false;
    }
}
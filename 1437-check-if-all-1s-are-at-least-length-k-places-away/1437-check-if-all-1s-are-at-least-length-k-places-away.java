class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prevInd = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(prevInd!=-1 && i-prevInd-1 < k){
                    return false;
                }
                prevInd = i;
            }
        }
        return true;
    }
}
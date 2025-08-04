class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n+1];
        for(int num : nums){
            if(num>0 && num<=n){
                flag[num] = true;
            }
        }
        for(int i=1;i<n;i++){
            if(!flag[i]){
                return i;
            }
        }
        return n;
    }
}
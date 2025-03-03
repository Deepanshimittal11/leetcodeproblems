class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] =1;

        for(int i=1;i<n;i++){
            result[i] = result[i-1]*nums[i-1];
        }
        int rightpdt =1;
        for(int i=n-2;i>=0;i--){
            rightpdt *= nums[i+1];
            result[i] *= rightpdt;
        }
        return result;
    }
}
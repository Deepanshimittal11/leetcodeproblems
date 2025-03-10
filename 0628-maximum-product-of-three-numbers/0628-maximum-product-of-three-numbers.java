class Solution {
    public int maximumProduct(int[] nums) {
        int pdt =1;
        for(int i=nums.length-1;i>=0;i--){
            pdt = pdt*nums[i];
        }
        return pdt;
    }
}
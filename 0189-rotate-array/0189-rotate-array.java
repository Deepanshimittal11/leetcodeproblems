class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k%n == 0) return;
        k = k%n;
        swap(nums, 0, n);
        swap(nums, 0, k);
        swap(nums, k, n);
    }
    public void swap(int[] nums, int i, int j){
        while(i<=j-1){
            int temp = nums[i];
            nums[i] = nums[j-1];
            nums[j-1] = temp;
            i++;
            j--;
        }
    }
}
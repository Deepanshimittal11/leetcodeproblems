class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;

        while(i<n && nums[i]>nums[i-1]) i++;
        if(i==1 || i==n) return false;
        int sorted = i;
        while(i<n && nums[i]<nums[i-1]) i++;
        if(i==sorted || i==n) return false;
        int desSorted = i;
        while(i<n && nums[i]>nums[i-1]) i++;
        return (i==n);
    }
}
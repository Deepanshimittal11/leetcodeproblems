class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0, r=0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int sum = 0, totalSum = 0;
        while(r<n){
            if(!set.contains(nums[r])){
                set.add(nums[r]);
                sum += nums[r];
                totalSum = Math.max(totalSum, sum);
                r++;
            }
            else{
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }
        return totalSum;
    }
}
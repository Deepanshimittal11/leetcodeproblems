class Solution {
    public int minimumCost(int[] nums) {
        int sum = 0;
        sum += nums[0];

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<nums.length;i++) arr.add(nums[i]);
        Collections.sort(arr);

        int min1 = arr.get(0);
        int min2 = arr.get(1);
        
        sum += (min1 + min2);
        return sum;
    }
}
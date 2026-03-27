class Solution {
    public boolean predictTheWinner(int[] nums) {
        //p1 can choose either 0th index element or (n-1)th index element.
        //p2 will choose max(oth index, (n-1)th index).
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        int s1 = solve(nums, 0, n-1);
        int s2 = total-s1;
        if(s1>=s2) return true;
        return false;
    }

    public int solve(int[] nums, int i, int j){
        if(i>j) return 0;
        if(i==j) return nums[i];

        int take_i = nums[i] + Math.min(solve(nums, i+2, j), solve(nums, i+1,j-1));
        int take_j = nums[j] + Math.min(solve(nums, i+1, j-1), solve(nums, i, j-2));

        return Math.max(take_i, take_j);
    }
}
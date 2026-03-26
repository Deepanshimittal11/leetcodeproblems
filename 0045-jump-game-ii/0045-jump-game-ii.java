class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // return solve(nums, 0, 0);
        int jumps = 0, l=0, r=0;
        while(r<n-1){
            int farthest = 0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l=r+1;
            r = farthest;
            jumps++; 
        }
        return jumps;
    }
    // public int solve(int[] nums, int ind, int jumps){
    //     int n = nums.length;
    //     if(ind >= n-1) return jumps;

    //     int mini = Integer.MAX_VALUE;
    //     for(int i=1;i<nums[ind];i++){
    //         mini = Math.min(mini, solve(nums, ind+i, jumps++));
    //     } 
    //     return jumps;
    // }
}
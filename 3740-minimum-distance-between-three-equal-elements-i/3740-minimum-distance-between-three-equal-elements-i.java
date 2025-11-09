class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if(n<3) return -1;
        
        int mindis = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        sum = (Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i));
                        mindis = Math.min(mindis, sum);
                    }
                }
            }
        }
        return mindis == Integer.MAX_VALUE ? -1 : mindis ;
    }
}
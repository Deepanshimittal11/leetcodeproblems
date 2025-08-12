class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if(n==0) return ans;
        int res = nums[0];
        for(int i=1;i<=n;i++){
            if(i==n || nums[i]!=nums[i-1]+1){
                if(res==nums[i-1]) ans.add(res+"");
                else{
                    ans.add(res+"->"+nums[i-1]);
                }
                if(i<n) res = nums[i];                
            }
        }
        return ans;
    }
}
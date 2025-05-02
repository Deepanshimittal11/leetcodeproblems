class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int maxcnt = 0;

        for(int i=0;i<n;i++){
            int cnt = 0;
            int num = nums[i];

            while(num!= 0){
                cnt++;
                num /= 10;
            }        
            if(cnt%2==0){
                maxcnt++;
            }
        }        
        return maxcnt;
    }
}
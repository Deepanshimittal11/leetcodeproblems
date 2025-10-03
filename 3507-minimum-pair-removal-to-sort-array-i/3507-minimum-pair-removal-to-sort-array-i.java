class Solution {
    public int minimumPairRemoval(int[] nums) {
        //star question...
        int n = nums.length;
        int cnt = 0;

        while(n>1){
            int minsum = Integer.MAX_VALUE;
            int minInd = -1;
            boolean dec = true;

            for(int i=1;i<n;i++){
                if(nums[i-1]+nums[i] < minsum){
                    //isme to hmne sum hi nikala h..
                    minsum = nums[i-1]+nums[i];
                    minInd = i-1;
                }
                //[5,2,3,1] me [3,1] (3 is greater).
                if(nums[i-1]>nums[i]){
                    dec = false;
                }
            }   
            //[5,2,3,1] last me jb [5,6] bn jaega tb 5 is smaller than 6 so we'll return total no. of operations (count).
            if(dec){
                return cnt;
            }
            //yha se arr decrease hona start hoga..
            //like [5,2,3,1] se [5,2,4] then [5,6]
            nums[minInd] = minsum; 

            for(int i = minInd+1;i<n-1;i++){
                nums[i] = nums[i+1];
            }      
            cnt++;
            n--;
        }
        return cnt;
    }
}
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int[] arr = new int[2*n];
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
            arr[i+n] = nums[i];
        }
        for(int i=0;i<n;i++){
            int tar = nums[i];
            if(tar>0){
                res[i] = arr[(i+tar)%n];
            }
            else if(tar<0){
                res[i] = arr[(i-tar+1)%n];
            }else{
                res[i] = tar;
            }
        }
        return res;
    }
}
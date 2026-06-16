class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int elem = 0;
        for(int i=0;i<n;i++){
            if(cnt == 0){
                cnt = 1;
                elem = nums[i];
            }
            else if(nums[i] == elem){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == elem) cnt1++;
            if(cnt1 > n/2) return elem;
        }
        return -1;
    }
}
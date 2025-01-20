class Solution {
    public int majorityElement(int[] nums) {
       int elem=0 ;
       int cnt =0;
       for(int i=0;i<nums.length;i++){
        if(cnt ==0){
            cnt =1;
            elem = nums[i];
        }
        else if(nums[i] == elem){
            cnt++;
        }
        else{
            cnt--;
        }
       } 
       int cnt1 =0;
       for(int i=0;i<nums.length;i++){
        if(elem==nums[i]){
            cnt1++;
        }
        if(cnt1 > nums.length/2){
            return elem;
        }    
       }
       return -1;
    }
}
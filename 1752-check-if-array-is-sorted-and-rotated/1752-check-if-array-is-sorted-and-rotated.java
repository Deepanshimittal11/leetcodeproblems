class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int elem = -1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                elem = i;
                break;
            }
        }
        if(elem!=-1){
            reverse(nums,0,elem);
            reverse(nums,elem+1,n-1);
            reverse(nums,0,n-1);
        }        
        int i =0;
        while(i<n-1){
            if(nums[i]>nums[i+1]){
                return false;
            }
            i++;
        }
        return true;
    }
    public void reverse(int[] nums,int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
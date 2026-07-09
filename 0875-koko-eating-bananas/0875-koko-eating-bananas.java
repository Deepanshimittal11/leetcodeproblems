class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles.length-1;
        int max = 0;
        for(int i=0;i<=r;i++){
            if(piles[i]>max) max = piles[i];
        }
        
        while(l<max){
            int mid = l + (max-l)/2;
            if(canEat(piles, mid, h)){
                max = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean canEat(int[] nums, int mid, int hr){
        int k = 0;
        for(int i=0;i<nums.length;i++){
            k += nums[i]/mid;
            if(nums[i]%mid != 0) k++;
        }
        return k<=hr ? true : false;
    }
}
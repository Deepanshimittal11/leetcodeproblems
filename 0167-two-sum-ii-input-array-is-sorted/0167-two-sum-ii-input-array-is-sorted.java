class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int[] ans = new int[2];
        int l = 0;
        int r = numbers.length-1;
        // time limit :
        // for(int i=0;i<numbers.length;i++){
        //     for(int j=i+1;j<numbers.length;j++){
        //         if(numbers[i]+numbers[j]==target){
        //             ans[0] = i+1;
        //             ans[1] = j+1;
        //             break;
        //         }
        //     }
        // }
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(sum==target){
                return new int[]{l+1,r+1};
            }
            else if(sum > target){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}
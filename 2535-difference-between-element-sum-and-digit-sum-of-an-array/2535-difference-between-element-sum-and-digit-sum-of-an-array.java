class Solution {
    public int differenceOfSum(int[] nums) {
        int elemSum = 0;
        int digitSum = 0;

        for(int num : nums){
            elemSum += num;
            if(num/10 == 0) digitSum += num;
            else{
                while(num > 0){
                    digitSum += num%10;
                    num /= 10;
                }
            }
        }
        return Math.abs(elemSum - digitSum);
    }
}
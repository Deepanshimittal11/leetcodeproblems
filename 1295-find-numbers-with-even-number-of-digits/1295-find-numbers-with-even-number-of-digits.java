class Solution {
    public int findNumbers(int[] nums) {
        int cnt =0;
            for(int num : nums){
                if(even(num)){
                    cnt++;
                }                
            }
        return cnt;
    }
    int digits(int num){
            if(num < 0){
                num = num*-1;
            }
            int cnt = 0;

            while(num > 0){
                cnt++;
                num = num/10;
            }
            return cnt;
        }

    boolean even(int num){
            int noOfDigits = digits(num);
            return noOfDigits % 2 == 0;
        }

}
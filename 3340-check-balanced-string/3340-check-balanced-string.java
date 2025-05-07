class Solution {
    public boolean isBalanced(String num) {
        int n = num.length();
        int sum = 0;
        for(int i=0;i<n;i++){
            int digit = num.charAt(i) - '0';
            if(i%2==0){
                sum += digit;
            }
            else{
                sum -= digit;
            }
        }
        if(sum==0){
            return true;
        }
        else{
            return false;
        }
    }
}
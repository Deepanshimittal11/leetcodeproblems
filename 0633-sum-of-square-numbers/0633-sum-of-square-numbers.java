class Solution {
    public boolean judgeSquareSum(int c) {
        long b = (int)Math.sqrt(c);
        long a = 0;
        while(a<=b){
            long sum = a*a+b*b;
            if(sum < c){
                a++;
            }
            else if(sum== c){
                return true;
            }
            else{
                b--;
            }
        }
        return false;
    }
}
class Solution {
    public double myPow(double x, int n) {
        long pow = n;
        if(n<0){
            x = 1/x;
            pow = -pow;
        }
        return power(x, pow);
    }
    public double power(double x, long pow){
        if(pow==0) return 1.0;
        double half = power(x, pow/2);
        if(pow%2==0){
            return half*half;
        }
        return x * half * half;
    }
}
class Solution {
public:
    bool isPowerOfFour(int n) {
        // if(sqrt(n)>0 && (n & (n-1)) == 0){
        //     return true;
        // }
        // else{
        //     return false;
        // }

        if(n<=0){
            return false;
        }
        while(n%4==0){
            n/=4;
        }
        return n==1;
    }
};
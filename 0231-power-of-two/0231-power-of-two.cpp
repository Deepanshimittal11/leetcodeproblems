class Solution {
public:
    bool isPowerOfTwo(int n) {        
        for(int x=0;x<=n/2;x++){
            if(n==pow(2,x)){
                return true;
            }
        }
        return false;
    }
};
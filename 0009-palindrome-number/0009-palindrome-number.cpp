class Solution {
public:
    bool isPalindrome(int x) {
        
        if(x<0){
            return false;
        }
        int original = x;
        long long ans = 0;
        while(x>0){
            int ld = x%10;
            x= x/10;
            ans = ans*10+ ld;
        }
        if( ans == original){
            return true;
        }
        return false;
    }
};
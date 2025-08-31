class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int res = x;
        int ans = 0;
        while(x > 0){
            int ld = x%10;
            ans = ans*10+ld;
            x /= 10;
        }
        // if(ans==x) return true;
        return (ans==res);
    }
}
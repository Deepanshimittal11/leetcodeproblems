class Solution {
    public int countDigits(int num) {
        int n = num;
        int cnt = 0;
        while(num > 0){
            int ld = num%10;
            if(n%ld==0) cnt++;
            num /= 10;
        }
        return cnt;
    }
}
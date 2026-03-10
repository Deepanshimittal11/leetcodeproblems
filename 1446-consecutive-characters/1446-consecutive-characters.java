class Solution {
    public int maxPower(String s) {
        char ch = s.charAt(0);
        int maxlen = 0, cnt = 1;
        int n = s.length();

        if(n==1) return 1;
        for(int i=1;i<n;i++){
            char c = s.charAt(i);
            if(c == ch){
                cnt++;
            }
            else{
                ch = c;
                cnt = 1;
            }
            maxlen = Math.max(maxlen, cnt);
        }
        return maxlen;
    }
}
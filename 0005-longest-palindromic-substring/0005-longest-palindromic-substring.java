class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 0, sp = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalin(i, j, s)){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxlen);
    }
    public boolean isPalin(int i, int j, String s){
        if(i>=j) return true;
        if(s.charAt(i)==s.charAt(j)) return isPalin(i+1, j-1, s);
        return false;
    }
}
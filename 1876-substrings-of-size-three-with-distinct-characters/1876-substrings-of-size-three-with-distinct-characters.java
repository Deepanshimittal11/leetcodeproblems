class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i=0;i<n-2;i++){
            if(s.charAt(i)!=s.charAt(i+1) && s.charAt(i)!=s.charAt(i+2) && s.charAt(i+1)!=s.charAt(i+2)){
                cnt++;
            }
        }
        return cnt;
    }
}
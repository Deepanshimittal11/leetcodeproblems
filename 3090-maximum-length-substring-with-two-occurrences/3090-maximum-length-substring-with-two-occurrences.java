class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int[] res = new int[26];
        int l =0;
        for(int r=0;r<s.length();r++){
            int index = s.charAt(r) - 'a';
            res[index]++;
            while(res[index]>2){
                res[s.charAt(l)-'a']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
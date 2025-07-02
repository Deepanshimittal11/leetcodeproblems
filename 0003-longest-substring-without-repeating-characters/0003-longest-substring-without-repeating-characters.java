class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxlen=0;
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        while(r<n){
            char ch = s.charAt(r);

            if(hash[ch]!=-1 && hash[ch]>=l){                
                l = hash[ch]+1;
            }

            int len = r-l+1;
            maxlen = Math.max(len, maxlen);
            hash[ch]=r;
            r = r+1;
        }
        return maxlen ;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(char c : t.toCharArray()){
            hash[c]++;
        }
        int l=0, r=0,cnt=0;
        int sIndex = -1;
        int minlen = Integer.MAX_VALUE;;
        int n = s.length();      

        while(r<n){
            hash[s.charAt(r)]--;
            if(hash[s.charAt(r)]>=0){
                cnt++;
            }
                
                while(cnt==t.length()){
                    if(r-l+1 < minlen){
                        minlen = r-l+1;
                        sIndex = l;
                    }
                    hash[s.charAt(l)]++;
                    if(hash[s.charAt(l)]>0) cnt--;
                    l++;
                }
                r=r+1;
            }            
        return sIndex== -1 ? "" : s.substring(sIndex,sIndex+minlen);
    }
}
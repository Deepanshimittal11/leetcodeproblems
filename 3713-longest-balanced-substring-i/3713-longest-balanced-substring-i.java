class Solution {
    public int longestBalanced(String s) {
        // int[] freq = new int[26];
        int maxi = 0;
        
        for(int i=0;i<s.length();i++){
            int[] freq = new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j) - 'a']++;
                if(isBalan(freq)){
                    int len = j-i+1;
                    maxi = Math.max(maxi, len);
                }
            }
        }
        return maxi;
    }
    public boolean isBalan(int[] freq){
        int first = 0;
        for(int f : freq){
            if(f>0){
                if(first == 0) first = f;
                else if(f != first) return false;
            }
        }
        return true;
    }
}
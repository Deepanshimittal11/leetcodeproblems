class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        int l = 0;
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);
            while(mpp.get(ch)>1){
                char c = s.charAt(l);
                mpp.put(c, mpp.get(c)-1);
                if(mpp.get(c)==0) mpp.remove(c);
                l++;
            }
            maxlen = Math.max(maxlen, mpp.size());
        }
        return maxlen;
    }
}
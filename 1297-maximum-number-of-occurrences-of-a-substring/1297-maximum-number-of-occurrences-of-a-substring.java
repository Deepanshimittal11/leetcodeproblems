class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<Character,Integer> mpp = new HashMap<>();
        Map<String, Integer> ans = new HashMap<>();
        int l=0;
        int r=0;
        int n = s.length();
        while(r<n){
            char ch = s.charAt(r);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            if(r-l+1>minSize){
                char c = s.charAt(l);
                mpp.put(c,mpp.get(c)-1);
                l++;
                if(mpp.get(c)<1){
                    mpp.remove(c);
                }
            }
            if(mpp.size()<=maxLetters && r-l+1==minSize){
                String str = s.substring(l,r+1);
                ans.put(str,ans.getOrDefault(str,0)+1);
            }
            r++;
        }
        int res = 0;
        for(int i : ans.values()){
            res = Math.max(res,i);
        }
        return res;
    }
}
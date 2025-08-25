class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int m = p.length();
        int[] paar = new int[26];
        int[] saar = new int[26];

        for(char chp : p.toCharArray()){
            paar[chp-'a']++;
        }
        int l=0;
        int r=0;
        while(r<n){
            char c = s.charAt(r);
            saar[c-'a']++;
            if(r-l+1>m){
                saar[s.charAt(l)-'a']--;
                l++;
            }
            if(Arrays.equals(saar,paar)){
                res.add(l);
            }
            r++;
        }
        return res;
    }
}
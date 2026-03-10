class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        int[] sArr = new int[26];
        int[] pArr = new int[26];

        for(int i=0;i<m;i++){
            char ch = p.charAt(i);
            pArr[ch - 'a']++;
        }

        int l = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            sArr[ch - 'a']++;
            if(i-l+1 > m){
                char c = s.charAt(l);
                sArr[c - 'a']--;
                l++;
            }
            if(Arrays.equals(sArr, pArr)) ans.add(l);
        }
        return ans;
    }
}
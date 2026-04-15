class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mppst = new HashMap<>();
        HashMap<Character, Character> mppts = new HashMap<>();

        int i=0, j=0;
        int n = s.length();
        int m = t.length();
        while(i<n && j<m){
            char a = s.charAt(i);
            char b = t.charAt(j);

            if(mppst.containsKey(a) && mppst.get(a)!=b){
                return false;
            }
            if(mppts.containsKey(b) && mppts.get(b)!=a){
                return false;
            }

            mppst.put(a, b);
            mppts.put(b, a);

            i++;
            j++;
        }
        return true;
    }
}
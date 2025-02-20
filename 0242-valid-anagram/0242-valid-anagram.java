class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> mpp = new HashMap<>();

        for(char i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            mpp.put(sChar, mpp.getOrDefault(sChar,0)+1);
        }

        for(int j=0;j<t.length();j++){
            char tChar = t.charAt(j);
            if(!mpp.containsKey(tChar)) return false;

            mpp.put(tChar, mpp.get(tChar)-1);

            if(mpp.get(tChar)==0){
                mpp.remove(tChar);
            }
        }
        return mpp.isEmpty();
    }
}
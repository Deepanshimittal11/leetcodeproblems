class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> mpp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mpp.put(ch, mpp.getOrDefault(ch,0)+1);
        }
        for(char c : t.toCharArray()){
            if(!mpp.containsKey(c) || mpp.get(c)==0){
                return c;
            }
            mpp.put(c, mpp.get(c)-1);
        }
        return ' ';
    }
}
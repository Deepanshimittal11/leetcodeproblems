class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(!map.containsValue(t.charAt(i))){
                    map.put(s.charAt(i), t.charAt(i));
                }
                else{
                    return false;
                }
            }
            else{
                char test = map.get(s.charAt(i));
                if(t.charAt(i) != test) return false;
            }
        }
        return true;
    }
}
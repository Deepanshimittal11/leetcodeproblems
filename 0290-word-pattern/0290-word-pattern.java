class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        if(word.length != pattern.length()){
            return false;
        }
        HashMap<Character, String> charToword = new HashMap<>();
        HashMap<String, Character> wordTochar = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String w = word[i];
            if(charToword.containsKey(c)){
                if(!charToword.get(c).equals(w)) return false;
            }   else charToword.put(c,w);
            
            if(wordTochar.containsKey(w)){
                if(wordTochar.get(w)!=c) return false;
            }   else wordTochar.put(w,c);
        }
        return true;
    }
}
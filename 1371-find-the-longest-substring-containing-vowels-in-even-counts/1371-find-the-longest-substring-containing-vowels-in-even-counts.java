class Solution {
    public int findTheLongestSubstring(String s) {
        int maxlen=0;
        Map<Character, Integer> vowels = new HashMap<>();
            vowels.put('a',0);
            vowels.put('e',1);
            vowels.put('i',2);
            vowels.put('o',3);
            vowels.put('u',4);
        Map<Integer,Integer> ch = new HashMap<>();
        ch.put(0,-1);
        int state = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(vowels.containsKey(c)){
                int bit = vowels.get(c);
                state ^= (1 << bit);
            }
            if(ch.containsKey(state)){
                maxlen = Math.max(maxlen, i-ch.get(state));
            }
            else{
                ch.put(state,i);
            }
        }
        return maxlen;
    }
}
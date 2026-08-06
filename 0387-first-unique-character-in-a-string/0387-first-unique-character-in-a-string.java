class Solution {
    public int firstUniqChar(String s) {
        // HashMap<Character, Integer> mpp = new HashMap<>();
        // for(char ch : s.toCharArray()){
        //     mpp.merge(ch, 1, Integer :: sum);
        // }
        // for(int i=0;i<s.length();i++){
        //     if(mpp.get(s.charAt(i))==1) return i;
        // }
        // return -1;

        //optimize
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mpp.merge(ch, 1, Integer :: sum);
        }
        for(int i=0;i<s.length();i++){
            if(mpp.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int cnt = 0;

        for(char c = 'a'; c < 'z'; c++){
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if(first<last){
                HashSet<Character> set = new HashSet<>();
                for(int i=first+1;i<last;i++){
                    set.add(s.charAt(i));
                }
                cnt += set.size();
            }
        }

        return cnt;
    }
}
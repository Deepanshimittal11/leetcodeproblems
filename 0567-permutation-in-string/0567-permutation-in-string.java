class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] s1cnt = new int[26];
        int[] win = new int[26];

        for(char ch : s1.toCharArray()){
            s1cnt[ch - 'a']++;
        }

        for(int i=0;i<s2.length();i++){
            win[s2.charAt(i)- 'a']++;

            if(i>=s1.length()){
                win[s2.charAt(i-s1.length())-'a']--;
            }
            if(Arrays.equals(s1cnt,win)){
                return true;
            }
        }
        return false;
    }
}
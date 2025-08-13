class Solution {
    public String longestPalindrome(String s) {
        for(int last = s.length();last>0;last--){
            for(int start = 0;start<=s.length()-last;start++){
                if(check(s,start, start+last)){
                    return s.substring(start, start+last);
                }
            }
        }
        return "";
    }
    private boolean check(String s, int i, int j){
        int left = i;
        int right = j-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') depth++;
            else{
                if(s.charAt(i)==')' && s.charAt(i-1)=='('){
                    ans += Math.pow(2, (depth-1));
                }
                depth--;
            }
        }
        return ans;
    }
}
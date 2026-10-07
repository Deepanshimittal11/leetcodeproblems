class Solution {
    Set<String> ans = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int open = 0, close = 0;
        for(char ch : s.toCharArray()){
            if(ch=='(') open++;
            else if(ch==')'){
                if(open>0) open--;
                else close++;
            }
        }
        StringBuilder str = new StringBuilder();
        helper(s, str, open, close, 0, 0);
        return new ArrayList<>(ans);
    }
    public void helper(String s, StringBuilder str, int open, int close, int ind, int bal){
        if(ind==s.length()){
            if(open==0 && close==0 && bal==0){
                ans.add(str.toString());
            }
            return;
        }
        char ch = s.charAt(ind);
        if(ch=='('){
            //remove
            if(open>0) helper(s, str, open-1, close, ind+1, bal);
            str.append(ch);
            //keep it
            helper(s, str, open, close, ind+1, bal+1);
            str.deleteCharAt(str.length()-1);
        }
        else if(ch==')'){
            if(close>0) helper(s, str, open, close-1, ind+1, bal);
            if(bal>0){
                str.append(ch);
                helper(s, str, open, close, ind+1, bal-1);
                str.deleteCharAt(str.length()-1);
            }
        }
        else{
            str.append(ch);
            helper(s, str, open, close, ind+1, bal);
            str.deleteCharAt(str.length()-1);
        }
    }
}
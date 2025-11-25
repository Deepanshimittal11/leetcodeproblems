class Solution {
    public Set<String> result = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') left++;
            else if(ch==')'){
                if(left>0) left--;
                else right++;
            }
        }
        helper(s, 0, left, right, 0, new StringBuilder());
        return new ArrayList<>(result);
    }
    public void helper(String str, int index, int left, int right, int bal, StringBuilder sb){
        if(left<0 || right<0 || bal<0) return;

        if(index == str.length()){
            if(left==0 && right==0 && bal==0){
                result.add(sb.toString());
            }
            return;
        }

        char ch = str.charAt(index);

        if(ch == '('){
            helper(str, index+1, left-1, right, bal, sb);
        }else if(ch == ')'){
            helper(str, index+1, left, right-1, bal, sb);
        }

        sb.append(ch);

        if(ch!='(' && ch!=')'){
            helper(str, index+1, left, right, bal, sb);
        }
        else if(ch=='('){
            helper(str, index+1, left, right, bal+1, sb);
        }
        else if(ch==')'){
            helper(str, index+1, left, right, bal-1, sb);
        }

        sb.deleteCharAt(sb.length()-1);
    }
}
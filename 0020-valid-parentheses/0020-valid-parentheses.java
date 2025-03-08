class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch== '('|| ch== '{'|| ch=='['){
                stack.add(ch);
            }

            else if(ch==')' || ch=='}' || ch==']'){
                if(stack.isEmpty() || !isMatchingPair(stack.pop(), ch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatchingPair(char open, char close){
        return(open=='('&& close==')' || open=='{'&& close=='}' || open=='['&& close==']');
    }
}
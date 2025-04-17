class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char a : num.toCharArray()){
            while(!st.isEmpty() && k>0 && (st.peek()- '0') > (a-'0')){
                st.pop();
                k--;
            }
            st.push(a);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char a : st) {
            sb.append(a);
        }

        while(sb.length() >0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }       
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
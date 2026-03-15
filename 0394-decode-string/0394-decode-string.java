class Solution {
    public String decodeString(String s) {
        Stack<Integer> cntst = new Stack<>();
        Stack<StringBuilder> strst = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }
            else if(ch == '['){
                cntst.push(num);
                strst.push(curr);

                num = 0;
                curr = new StringBuilder();
            }
            else if(ch == ']'){
                int repeat = cntst.pop();
                StringBuilder prev = strst.pop();

                for(int i=1;i<=repeat;i++){
                    prev.append(curr);
                }
                curr = prev;
            }
            else{ //if ch is an alphabet;
                curr.append(ch);
            }
        } 
        return curr.toString();
    }
}
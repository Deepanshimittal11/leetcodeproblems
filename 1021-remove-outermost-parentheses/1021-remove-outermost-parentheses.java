class Solution {
    public String removeOuterParentheses(String s) {
        List<Character> ans = new ArrayList<>();
        char[] charArray = s.toCharArray();

        int opencnt =0;
        for(int i=0;i<charArray.length;i++){
            char c = charArray[i];

            if(c == '('){
                if(opencnt > 0){
                    ans.add(c);
                }
                opencnt++;
            }
            else if(c== ')'){
                opencnt--;
                if(opencnt>0){
                    ans.add(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(Character ch: ans){
            result.append(ch);
        }
        return result.toString();
    }
}
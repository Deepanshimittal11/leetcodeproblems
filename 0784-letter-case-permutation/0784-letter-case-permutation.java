class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtracking(s.toCharArray(), 0);
        return ans;
    }

    public void backtracking(char[] str, int ind){
        if(ind==str.length){
            ans.add(new String(str));
            return;
        }
        
        if(Character.isLetter(str[ind])){
            //small char
            str[ind] = Character.toLowerCase(str[ind]);
            backtracking(str, ind+1);

            //big char
            str[ind] = Character.toUpperCase(str[ind]);
            backtracking(str, ind+1);
        }
        else{
            backtracking(str, ind+1);
        }
    }
}
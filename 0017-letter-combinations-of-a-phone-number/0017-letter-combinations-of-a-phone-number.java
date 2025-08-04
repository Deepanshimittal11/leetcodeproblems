class Solution {
    public static String[] number = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        backtrack(res, digits, 0,"");
        return res;       
    }
    private void backtrack(List<String> res, String digits, int index, String curr){
        if(index==digits.length()){
            res.add(curr);
            return;
        }
        String letter = number[digits.charAt(index)-'2'];
        for(char ch : letter.toCharArray()){
            backtrack(res,digits,index+1,curr+ch);
        }
    } 
}
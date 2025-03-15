class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }
    private void backtrack(List<String> result, String curr, int opencnt, int closecnt , int n){
        if(curr.length()== 2*n){
            result.add(curr);
            return;
        }
        if (opencnt < n) {
            backtrack(result, curr + "(", opencnt + 1, closecnt, n);
        }
        if (closecnt < opencnt) {
            backtrack(result, curr + ")", opencnt, closecnt + 1, n);
        }
    }
}
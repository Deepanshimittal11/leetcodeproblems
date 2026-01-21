class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> validStrings(int n) {
        backtrack(0, n, new StringBuilder());
        return ans;
    }
    
    public void backtrack(int ind, int n, StringBuilder str){
        if(ind==n){
            if(isValid(str.toString())) ans.add(str.toString());
            return;
        }

        ///take 0
        str.append('0');
        backtrack(ind+1, n, str);
        str.deleteCharAt(str.length()-1);

        //take 1
        str.append('1');
        backtrack(ind+1, n, str);
        str.deleteCharAt(str.length()-1);
    }
    public boolean isValid(String s){
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='0') return false;
        }
        return true;
    }
}
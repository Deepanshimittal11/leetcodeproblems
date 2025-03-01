class Solution {
    public boolean isValid(String s) {
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='('&& s.charAt(i+1)==')'){
                return true;
            }
            else if(s.charAt(i)=='['&& s.charAt(i+1)==']'){
                return true;
            }
            else if(s.charAt(i)=='{'&& s.charAt(i+1)=='}'){
                return true;
            }
        }
        return false;
    }
}
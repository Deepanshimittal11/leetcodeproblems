class Solution {
    public boolean checkValidString(String s) {
        int opencnt = 0, closecnt = 0;
        int star = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') {
                opencnt++;
            }
            else if(ch == ')'){
                closecnt++;
            }
            else if(ch=='*'){
                star++;
            }
        }
        // if(opencnt==closecnt) return true;
        if(opencnt != closecnt && Math.abs(opencnt-closecnt)>star) return false;
        return true;
    }
}
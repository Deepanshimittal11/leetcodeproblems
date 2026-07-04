class Solution {
    public int minAddToMakeValid(String s) {
        int cntopen = 0;
        int cntclose = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                cntopen++;
            }
            else{
                if(cntopen>0){
                    cntopen--;
                }
                else{
                    cntclose++;
                }
            }
        }
        int ans = cntopen + cntclose;
        return ans;
    }
}
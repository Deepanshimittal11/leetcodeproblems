class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int bcnt = 0;
        int delete = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b') bcnt++;
            else{
                delete = Math.min(delete+1, bcnt);
            }
        }
        return delete;
    }
}
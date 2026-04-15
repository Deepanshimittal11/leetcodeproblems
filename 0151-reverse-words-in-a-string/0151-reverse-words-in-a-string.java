class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        int r = str.length()-1;
        StringBuilder res = new StringBuilder();

        while(r>=0){
            int l = r;
            while(l>=0 && str.charAt(l) != ' '){
                l--;
            }
            for(int j=l+1;j<=r;j++){
                res.append(str.charAt(j));
            }
            res.append(" ");
            r=l-1;
            while(r>=0 && str.charAt(r)==' ') r--;
        }
        return res.toString().trim();
    }
}
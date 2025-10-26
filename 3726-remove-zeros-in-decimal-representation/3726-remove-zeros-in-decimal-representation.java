class Solution {
    public long removeZeros(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch != '0'){
                sb.append(ch);
            }
        }
        str = sb.toString();
        long ans = 0;
        ans = Long.parseLong(str);
        return ans;
    }
}
class Solution {
    public String modifyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '?'){
                for(char c='a';c<='z';c++){
                    if(i>0 && sb.charAt(i-1)==c) continue;
                    if(i<n-1 && s.charAt(i+1)==c) continue;
                    sb.append(c);
                    break;
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        while(sb.length() > 2){
        StringBuilder next = new StringBuilder();   
            for(int i=0;i<sb.length()-1;i++){
                int a = sb.charAt(i) - '0';
                int b = sb.charAt(i+1) - '0';
                int sum = (a+b);
                int ld = sum%10;
                next.append(ld);
            }
            sb = next;
        } 
        if(sb.charAt(0) == sb.charAt(1)){
            return true;
        }       
        return false;
    }
}
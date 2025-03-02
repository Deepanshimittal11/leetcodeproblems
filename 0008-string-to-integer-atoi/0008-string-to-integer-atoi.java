class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if(s.isEmpty()) return 0;

        int sign = 1;
        int startIndex = 0;
        if(s.charAt(0)=='-'){
            sign = -1;
            startIndex++;
        }
        else if(s.charAt(0)=='+'){
            startIndex++;
        }

        long result =0;
        for(int i=startIndex; i<s.length();i++){
            char c = s.charAt(i);

            if(!Character.isDigit(c)){
                break;
            }
            result = result*10 + (c-'0');
            if(result > Integer.MAX_VALUE){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int)result*sign;
    }
}
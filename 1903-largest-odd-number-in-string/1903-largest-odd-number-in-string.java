class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        StringBuilder str = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            char ch = num.charAt(i);
            if((ch - '0') % 2 != 0){
                int temp = i;
                for(int j=0;j<=temp;j++){
                    str.append(num.charAt(j));
                }
                return str.toString();
            }
            else{
                continue;
            }
        }
        return "";
    }
}
class Solution {
    public String addStrings(String num1, String num2) {
        //it will run for small numbers only.
        // Integer n1 = Integer.parseInt(num1);
        // Integer n2 = Integer.parseInt(num2);
        // int add = n1+n2;
        // return Integer.toString(add);

        int n = num1.length()-1;
        int m = num2.length()-1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;

        while(n>=0 || m>=0 || carry!=0){
            int c1 = (n>=0) ? num1.charAt(n)-'0' : 0;
            int c2 = (m>=0) ? num2.charAt(m)-'0' : 0;
            int add = c1+c2+carry;
            ans.append(add%10);
            carry = add/10;
            n--;
            m--;
        }
        return ans.reverse().toString();
    }
}
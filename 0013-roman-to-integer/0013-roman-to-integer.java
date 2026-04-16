class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);

        //I can be placed before V (5) and X (10) to make 4 and 9. 
        // X can be placed before L (50) and C (100) to make 40 and 90. 
        // C can be placed before D (500) and M (1000) to make 400 and 900.
        int n = s.length();
        int ans = 0, i=0;
        while(i<n-1){
            char ch = s.charAt(i);
            char ch1 = s.charAt(i+1);
            if(ch=='I' && (ch1=='V' || ch1=='X')){
                ans += (mpp.get(ch1) - mpp.get(ch));
                i+=2;
            }
            else if(ch=='X' && (ch1=='L' || ch1=='C')){
                ans += (mpp.get(ch1) - mpp.get(ch));
                i+=2;
            }
            else if(ch=='C' && (ch1=='D' || ch1=='M')){
                ans += (mpp.get(ch1) - mpp.get(ch));
                i+=2;
            }
            else{
                ans += mpp.get(ch);
                i++;
            }
        }
        if(i==n-1) ans = ans+mpp.get(s.charAt(n-1));
        return ans;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mpp.put(ch, mpp.getOrDefault(ch, 0)+1);
        }

        int ans = 0;
        boolean oddfound = false;
        //a-1,b-1,c-4,d-2
        //bananas -> b-1,a-3,n-2,s-1

        for(int value : mpp.values()){
            if(value%2==0){
                ans += value;
            }
            else{
                ans += value-1;
                oddfound = true;
            }
        }
        if(oddfound) ans += 1;
        return ans;
    }
}
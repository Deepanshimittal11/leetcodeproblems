class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int maxcnt = 0;
        int cnt = 0;

        for(int x=0;x<n;x++){                
            char ch = s.charAt(x);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                cnt++;
            }
            if(x>=k){
                char c = s.charAt(x-k);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') cnt--;
            }
            maxcnt = Math.max(maxcnt, cnt);
        }
        
        return maxcnt;
    }
}
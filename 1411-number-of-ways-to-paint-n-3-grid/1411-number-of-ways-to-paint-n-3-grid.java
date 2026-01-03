class Solution {
    int mod = (int) 1e9+7;
    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;

        for(int i=2;i<=n;i++){
            long newAba = (aba*3 + abc*2)% mod;
            long newAbc = (aba*2 + abc*2) % mod;

            aba = newAba;
            abc = newAbc;
        }

        return (int) (aba + abc) % mod;
    }
}
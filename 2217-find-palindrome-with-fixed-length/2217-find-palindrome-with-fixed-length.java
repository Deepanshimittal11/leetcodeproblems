class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans = new long[queries.length];
        int halflen = (intLength + 1)/2;
        long start = (long)Math.pow(10, halflen-1);
        for(int i=0;i<queries.length;i++){
            long half = start + queries[i] - 1;
            String s = String.valueOf(half);

            if(s.length()>halflen){
                ans[i] = -1;
                continue;
            }

            StringBuilder sb = new StringBuilder(s);
            String rev = new StringBuilder(
                (intLength%2==0) ? s : s.substring(0, s.length()-1)
            ).reverse().toString();

            ans[i] = Long.parseLong(s+rev);
        }
        return ans;
    }
}
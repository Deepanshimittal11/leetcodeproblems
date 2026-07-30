class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int dig = n/8;
        int rem = n%8;
        if(n<8) return n;
        else if(dig==1){
            return 8+(rem*2);
        }
        int sum = 0;
        for(int i=1;i<=dig;i++){
            sum += 8*i;
        }
        return sum+(rem*(dig+1));
    }
}
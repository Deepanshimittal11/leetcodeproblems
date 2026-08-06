class Solution {
    public int smallestNumber(int n, int t) {
        //because of the infinite while loop that we are running it will not go outside this loop and will not throw compile time error(since we had not use the return statement outside the loop).
        while(true){
            int pdt = 1;
            int temp = n;
            while(temp>0){
                pdt *= (temp%10);
                temp /= 10;
            }
            if(pdt%t==0) return n;
            n++;
        }
    }
}
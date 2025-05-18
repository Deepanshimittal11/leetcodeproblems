class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            n = sumOfSq(n);
        }
        return n==1;
    }
    
    public int sumOfSq(int n){
        int sum = 0;
        while(n>0){
            int ld = n%10;
            sum += ld*ld;
            n /= 10;
        }
        return sum;
    }
}
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int num : nums){
            arr.add(num);
            while(arr.size()>1){
                int a = arr.get(arr.size()-1);
                int b = arr.get(arr.size()-2);
                int gcdi = gcd(a,b);
                if(gcdi == 1) break;
                long lcm = (long)a/gcdi *b;
                arr.remove(arr.size()-1);
                arr.remove(arr.size()-1);
                arr.add((int)lcm);
            }
        }
        return arr;
    }
    public int gcd(int a, int b){
        while(b!=0){
            int temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}
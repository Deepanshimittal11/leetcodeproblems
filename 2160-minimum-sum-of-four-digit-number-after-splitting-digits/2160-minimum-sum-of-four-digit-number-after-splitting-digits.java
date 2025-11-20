class Solution {
    public int minimumSum(int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ld = 0;
        int rem = 0;

        while(num > 0){
            ld = num%10;
            rem = num/10;
            num = rem;
            pq.offer(ld);
        }
        
        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();
        int d = pq.poll();

        int x = a*10 + c;
        int y = b*10 + d;

        return x+y;
    }
}
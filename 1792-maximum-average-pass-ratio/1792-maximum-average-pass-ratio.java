class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for(int[] cls : classes){
            int pass = cls[0];
            int std = cls[1];
            double gain = gain(pass, std);
            pq.offer(new double[]{gain, pass, std});
        }
        while(extraStudents-- > 0){
            double[] curr = pq.poll();
            int pass = (int)curr[1];
            int std = (int)curr[2];
            pass++;
            std++;
            double gain = gain(pass,std);
            pq.offer(new double[]{gain, pass, std});
        }
        double sum = 0;
        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            sum += curr[1]/curr[2];
        }
        return sum/classes.length;
    }
    double gain(int pass, int std){
        return ((double)(pass+1)/(std+1)) - ((double)(pass)/(std));
    }
}
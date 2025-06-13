class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;
        int rightInd = n-1;
        int maxlen = 0;
        for(int i=0;i<k;i++){
            leftSum += cardPoints[i];
            maxlen = leftSum;
        }
        
        for(int i=k-1;i>=0;i--){
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rightInd];
            rightInd = rightInd - 1;
            maxlen = Math.max(leftSum+rightSum, maxlen);
        }
        return maxlen;
    }
}
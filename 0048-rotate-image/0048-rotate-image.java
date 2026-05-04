class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //sbse phle vertical lines ko horizontal kia.
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //uske baad 1st and 3rd vertical lines ko swap krdia.
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        // int n= matrix.size();
        for(int i=0;i<matrix.length-1;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }
    private void reverse(int[] row){
        int start = 0;
        int end = row.length-1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}
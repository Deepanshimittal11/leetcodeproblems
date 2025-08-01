class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 0;row<numRows;row++){
            List<Integer> currRow = new ArrayList<>();
            int val = 1;
            for(int col = 0;col<=row;col++){
                currRow.add(val);
                val = val * (row-col)/(col+1);
            }
            ans.add(currRow);
        }
        return ans;
    }
}
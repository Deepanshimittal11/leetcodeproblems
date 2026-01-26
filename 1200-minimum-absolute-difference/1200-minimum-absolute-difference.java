class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);

        //1 2 3 4
        int mindiff = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i] < mindiff){
                mindiff = arr[i+1]-arr[i];
            }
        }
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]==mindiff){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return ans;
    }
}
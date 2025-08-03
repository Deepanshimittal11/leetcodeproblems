class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> mpp = new HashMap<>();
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for(int i=0;i<list1.length;i++){
            mpp.put(list1[i],i);
        }

        for(int j=0;j<list2.length;j++){
            String word = list2[j];
            if(mpp.containsKey(word)){
                int sum = j + mpp.get(word);
                if(sum < minSum){
                    res.clear(); //if minsum == sum if found first but then we found sum<minsum that is why we use clear();
                    res.add(word);
                    minSum = sum;
                }
                else if(minSum == sum){
                    res.add(word);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
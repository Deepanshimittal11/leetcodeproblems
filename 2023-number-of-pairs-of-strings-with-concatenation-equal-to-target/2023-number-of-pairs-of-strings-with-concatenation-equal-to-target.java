class Solution {
    public int numOfPairs(String[] nums, String target) {
        int cnt = 0;
        Map<String, Integer> mpp = new HashMap<>();
        for(String str : nums){
            mpp.put(str, mpp.getOrDefault(str,0)+1);
        }
        for(String str : nums){
            if(target.startsWith(str)){
                int len = str.length();
                String sub = target.substring(len);
                if(mpp.containsKey(sub)){
                    cnt += mpp.get(sub);
                }
                if(str.equals(sub)) cnt--;
            }
        }
        return cnt;
    }
}
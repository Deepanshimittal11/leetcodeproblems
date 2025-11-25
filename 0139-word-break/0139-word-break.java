class Solution {
    Set<String> dict;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        return dfs(s, 0);
    }
    private boolean dfs(String s, int start){
        if(start == s.length()) return true;
        if(memo[start] != null) return memo[start];

        for(int end = start+1; end<=s.length(); end++){
            String sub = s.substring(start, end);
            if(dict.contains(sub) && dfs(s, end)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
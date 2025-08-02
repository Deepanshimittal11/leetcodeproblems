class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        //convert nums to string:
        for(int i=0;i<nums.length;i++){
            str[i] = String.valueOf(nums[i]);
        }
        //compare which combo is bigger:
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));

        if(str[0].equals("0")) return "0";
        
        //final res:
        StringBuilder res = new StringBuilder();
        for(String num : str){
            res.append(num);
        }
        return res.toString();
    }
}
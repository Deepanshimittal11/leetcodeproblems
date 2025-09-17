class Solution {
    public int[] singleNumber(int[] nums) {
        //find XOR
        //find pos
        //move posnth value to right
        //we're basically dividing nums into two parts.
        //1st step
        int xor = 0;
        // int[] ans = new int[2];
        for(int num : nums){
            xor ^= num;
        }
        //2nd step
        int pos = xor & -xor;
        int a=0;
        int b=0;        
        for(int num : nums){
            //in this if - we're finding a bit which have pos set.
            if((num & pos)==0){
                a ^= num;
            }
            //pos unset
            else{
                b ^= num;
            }
        }
        // ans[0] = a;
        // ans[1] = b;
        return new int[]{a,b};
    }
}
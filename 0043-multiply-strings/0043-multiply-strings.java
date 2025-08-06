class Solution {
    public String multiply(String nums1, String nums2) {
        if(nums1.equals("0") || nums2.equals("0")) return "0";
        int n = nums1.length();
        int m = nums2.length();
        // int sum = 0;
        int[] arr = new int[m+n];
        for(int i=n-1;i>=0;i--){
            int dig1 = nums1.charAt(i)-'0';
            for(int j=m-1;j>=0;j--){
                int dig2 = nums2.charAt(j)-'0';
                int pdt = dig1*dig2;
                int sum = pdt + arr[i+j+1];
                arr[i+j+1] = sum%10;
                arr[i+j] += sum/10;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int num : arr){
            if(str.length()==0 && num==0) continue;
            str.append(num);
        }
        return str.toString();
    }
}